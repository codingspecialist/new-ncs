package shop.mtcoding.blog.course.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception404;
import shop.mtcoding.blog.course.Course;
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

    public ExamResponse.ExamStartDTO 나의시험(User sessionUser, Long paperId) {
        Paper paperPS = paperRepository.findById(paperId)
                .orElseThrow(() -> new Exception404("시험지가 존재하지 않아요"));

        List<SubjectElement> subjectElementListPS =
                elementRepository.findBySubjectId(paperPS.getSubject().getId());

        String studentName = sessionUser.getStudent().getName();

        List<Question> questionListPS = questionRepository.findByPaperId(paperId);

        // 시험일, 시험장소, 교과목명, 훈련교사명, 학생명, 문항수, 평가요소(elements), 시험문제들(문항점수포함)
        return new ExamResponse.ExamStartDTO(paperPS, studentName, subjectElementListPS, questionListPS);
    }

    public ExamResponse.MyPaperListDTO 나의시험목록(Long sessionUserId) {
        User userPS = userRepository.findByStudent(sessionUserId)
                .orElseThrow(() -> new Exception404("당신은 학생이 아니에요 : 관리자에게 문의하세요."));

        Course coursePS = userPS.getStudent().getCourse();

        List<Paper> papers = paperRepository.findByCourseId(coursePS.getId());

        Map<Long, Boolean> attendanceMap = new HashMap<>();
        papers.stream().forEach(paper -> {
            Optional<Exam> examPS = examRepository.findByPaperIdAndStudentId(paper.getId(), userPS.getStudent().getId());
            if(examPS.isPresent()){
                attendanceMap.put(paper.getId(), true);
            }else{
                attendanceMap.put(paper.getId(), false);
            }
        });

        return new ExamResponse.MyPaperListDTO(userPS.getStudent().getId(), papers, attendanceMap);
    }

    @Transactional
    public void 시험결과저장(ExamRequest.SaveDTO reqDTO, User sessionUser) {
        // 1. Exam 저장
        Paper paper = paperRepository.findById(reqDTO.getPaperId())
                .orElseThrow(() -> new Exception404("시험지를 찾을 수 없어요"));

        Student student = studentRepository.findByUserId(sessionUser.getId());

        Exam exam = reqDTO.toEntity(paper, student, "", 0, 0);
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
        int score = examAnswerList.stream().mapToInt(value -> value.getIsCorrect() ? value.getQuestion().getPoint() : 0).sum();
        examPS.updatePointAndGrade(score);

        // 5. 학생 제출 답안 저장하기
        examAnswerRepository.saveAll(examAnswerList);
    }
}