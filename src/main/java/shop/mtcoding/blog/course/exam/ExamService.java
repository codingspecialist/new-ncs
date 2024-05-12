package shop.mtcoding.blog.course.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception403;
import shop.mtcoding.blog._core.errors.exception.Exception404;
import shop.mtcoding.blog.course.exam.answer.ExamAnswer;
import shop.mtcoding.blog.course.exam.answer.ExamAnswerRepository;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.course.student.StudentRepository;
import shop.mtcoding.blog.course.subject.SubjectRepository;
import shop.mtcoding.blog.course.subject.element.SubjectElement;
import shop.mtcoding.blog.course.subject.element.SubjectElementRepository;
import shop.mtcoding.blog.paper.Paper;
import shop.mtcoding.blog.paper.PaperRepository;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.QuestionRepository;
import shop.mtcoding.blog.user.User;
import shop.mtcoding.blog.user.UserRepository;

import java.util.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final ExamAnswerRepository examAnswerRepository;
    private final PaperRepository paperRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final SubjectElementRepository elementRepository;
    private final QuestionRepository questionRepository;


    // 총평 수정하면서, 결과 점수도 같이 수정한다.
    @Transactional
    public void 총평남기기(ExamRequest.UpdateDTO reqDTO) {
        Exam examPS = examRepository.findById(reqDTO.getExamId())
                .orElseThrow(() -> new Exception404("응시한 시험이 존재하지 않아요"));

        List<ExamAnswer> examAnswers = examPS.getExamAnswers();

        examAnswers.forEach(answer -> {
            reqDTO.getAnswers().forEach(answerDTO -> {
                if(answerDTO.getAnswerId().longValue() == answer.getId().longValue()){
                    answerDTO.update(answer.getQuestion(), answer);
                }
            });
        });

        // 4. 시험점수, 수준, 통과여부 업데이트 하기
        double score = examAnswers.stream().mapToInt(value -> value.getIsCorrect() ? value.getQuestion().getPoint() : 0).sum();

        // 5. 재평가지로 시험쳤으면 10%
        if(examPS.getExamState().equals("재평가")){
            score = score * 0.9;
        }

        // 6. 점수 입력 수준 입력
        examPS.updatePointAndGrade(score);

        // 7. 코멘트 수정 (총평 남기기, 총평 남긴 시간 남기기)
        examPS.updateTeacherComment(reqDTO.getTeacherComment());
    }

    public ExamResponse.ResultDetailDTO 시험친결과상세보기(Long examId) {
        Exam examPS = examRepository.findById(examId)
                .orElseThrow(() -> new Exception404("응시한 시험이 존재하지 않아요"));

        List<SubjectElement> subjectElementListPS =
                elementRepository.findBySubjectId(examPS.getPaper().getSubject().getId());

        User teacher = userRepository.findByTeacherName(examPS.getTeacherName())
                .orElseThrow(() -> new Exception404("해당 시험에 선생님이 존재하지 않아서 사인을 찾을 수 없어요"));

        return new ExamResponse.ResultDetailDTO(examPS, subjectElementListPS, teacher);
    }

    public ExamResponse.StartDTO 시험응시(User sessionUser, Long paperId) {
        Paper paperPS = paperRepository.findById(paperId)
                .orElseThrow(() -> new Exception404("시험지가 존재하지 않아요"));

        List<SubjectElement> subjectElementListPS =
                elementRepository.findBySubjectId(paperPS.getSubject().getId());

        Student studentPS = studentRepository.findByUserId(sessionUser.getId());

        String studentName = studentPS.getName();

        List<Question> questionListPS = questionRepository.findByPaperId(paperId);

        // 시험일, 시험장소, 교과목명, 훈련교사명, 학생명, 문항수, 평가요소(elements), 시험문제들(문항점수포함)
        return new ExamResponse.StartDTO(paperPS, studentName, subjectElementListPS, questionListPS);
    }

    public ExamResponse.MyPaperListDTO 나의시험목록(User sessionUser) {
        // 1. 해당 학생이 소속된 과정의 모든 시험지 검색 (쿼리발동)
        List<Paper> papers = paperRepository.findByCourseId(sessionUser.getStudent().getCourse().getId());

        // 2. 시험을 검색해서, 해당 시험지로 시험을 쳤는지 안쳤는지 여부 검색 (쿼리발동)
        List<Exam> examListPS = examRepository.findByStudentId(sessionUser.getStudent().getId());

        Map<Long, Boolean> attendanceMap = new HashMap<>();
        examListPS.forEach(exam -> {
            papers.forEach(paper -> {
                if(exam.getPaper().getId().equals(paper.getId())){
                    attendanceMap.put(paper.getId(), true);
                }
            });
        });

        return new ExamResponse.MyPaperListDTO(sessionUser.getStudent().getId(), papers, attendanceMap);
    }

    @Transactional
    public void 시험결과저장(ExamRequest.SaveDTO reqDTO, User sessionUser) {
        // 1. Exam 저장
        Paper paper = paperRepository.findById(reqDTO.getPaperId())
                .orElseThrow(() -> new Exception404("시험지를 찾을 수 없어요"));

        Student student = studentRepository.findByUserId(sessionUser.getId());

        // 2. 재평가인데, 이전 시험(Exam)이 있으면 60점미만 미통과, 없으면 결석
        String reExamReason = "";
        if(paper.getPaperState().equals("재평가")){
            Optional<Exam> examOP = examRepository.findByOrigin(paper.getSubject().getId(), student.getId());

            if(examOP.isPresent()){
                reExamReason = "미통과";
            }else{
                reExamReason = "결석";
            }
        }


        Exam exam = reqDTO.toEntity(paper, student, paper.getPaperState(), 0.0, 0, reExamReason);
        Exam examPS = examRepository.save(exam);

        // 2. 정답지 가져오기
        List<Question> questionList = questionRepository.findByPaperId(reqDTO.getPaperId());

        // 3. ExamAnswer 컬렉션 저장 (채점하기)
        List<ExamAnswer> examAnswerList = new ArrayList<>();

        questionList.forEach(question -> {
            // 순회하면서 채점
            reqDTO.getAnswers().forEach(answerDTO -> {
                if(answerDTO.getQuestionNo() == question.getNo()){
                    examAnswerList.add(answerDTO.toEntity(question, examPS));
                }
            });
        });

        // 4. 시험점수, 수준, 통과여부 업데이트 하기
        double score = examAnswerList.stream().mapToInt(value -> value.getIsCorrect() ? value.getQuestion().getPoint() : 0).sum();

        // 5. 재평가지로 시험쳤으면 10%
        if(paper.getPaperState().equals("재평가")){
            score = score * 0.9;
        }

        // 6. 점수 입력 수준 입력
        examPS.updatePointAndGrade(score);

        // 7. 총평 자동화
        String teacherGoodComment = "";
        String teacherBadComment = "";

        for (ExamAnswer examAnswer : examAnswerList) {
            if(examAnswer.getIsCorrect()){
                teacherGoodComment += examAnswer.getQuestion().getSubjectElement().getSubtitle() + ", ";
            }else{
                teacherBadComment += examAnswer.getQuestion().getSubjectElement().getSubtitle() + ", ";
            }
        }

        int goodIndex = teacherGoodComment.lastIndexOf(", ");
        int badIndex = teacherBadComment.lastIndexOf(", ");

        if(goodIndex != -1) teacherGoodComment = teacherGoodComment.substring(0, goodIndex);

        if(badIndex != -1) teacherBadComment = teacherBadComment.substring(0, badIndex);

        if(teacherGoodComment.length() > 0){
            if(teacherBadComment.length() == 0){
                teacherGoodComment += " 부분을 잘이해하고 있습니다.";
            }else{
                teacherGoodComment += " 부분을 잘이해하고 있고, ";
            }
        }

        if(teacherBadComment.length() > 0){
            teacherBadComment += " 부분이 부족합니다.";
        }

        examPS.updateTeacherComment(teacherGoodComment + teacherBadComment);

        // 5. 학생 제출 답안 저장하기
        examAnswerRepository.saveAll(examAnswerList);
    }


    public List<ExamResponse.ResultDTO> 시험결과리스트(User sessionUser) {
        if(sessionUser.getStudent() == null) throw new Exception403("당신은 학생이 아니에요 : 관리자에게 문의하세요");
        List<Exam> examListPS = examRepository.findByStudentId(sessionUser.getStudent().getId());

        // PK, 번호(교과목번호), 과정명/회차, paper.getSubject(교과목), 시험유형, 학생명, 훈련강사, 결과점수, 통과여부, (통과못했거나, 재평가지로 재평가하기버튼필요)
        return examListPS.stream().map(ExamResponse.ResultDTO::new).toList();
    }

    public List<ExamResponse.ResultDTO> 교과목별시험결과(Long subjectId) {
        List<Exam> examListPS = examRepository.findBySubjectId(subjectId);

        // 시험지를 학생 이름 순으로 정렬
        Collections.sort(examListPS, Comparator.comparing(exam -> exam.getStudent().getName()));

        return examListPS.stream().map(ExamResponse.ResultDTO::new).toList();
    }

    @Transactional
    public void 학생사인저장(ExamRequest.StudentSignDTO reqDTO, User sessionUser) {
        Exam examPS = examRepository.findById(reqDTO.getExamId())
                .orElseThrow(() -> new Exception404("응시한 시험이 존재하지 않아요"));

        examPS.updateSign(reqDTO.getSign());
    }
}
