package shop.mtcoding.blog.course.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception404;
import shop.mtcoding.blog.course.Course;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.course.student.StudentRepository;
import shop.mtcoding.blog.course.subject.SubjectRepository;
import shop.mtcoding.blog.course.subject.element.SubjectElement;
import shop.mtcoding.blog.course.subject.element.SubjectElementRepository;
import shop.mtcoding.blog.paper.Paper;
import shop.mtcoding.blog.paper.PaperRepository;
import shop.mtcoding.blog.paper.PaperResponse;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.QuestionRepository;
import shop.mtcoding.blog.user.User;
import shop.mtcoding.blog.user.UserRepository;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final PaperRepository paperRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final SubjectElementRepository elementRepository;
    private final QuestionRepository questionRepository;
    
    public ExamResponse.ExamStartDTO 나의시험(User sessionUser, Long paperId){
        Paper paperPS = paperRepository.findById(paperId)
                .orElseThrow(() -> new Exception404("시험지가 존재하지 않아요"));

        List<SubjectElement> subjectElementListPS =
                elementRepository.findBySubjectId(paperPS.getSubject().getId());

        String studentName = sessionUser.getStudent().getName();

        List<Question> questionListPS = questionRepository.findByPaperId(paperId);
        
        // 시험일, 시험장소, 교과목명, 훈련교사명, 학생명, 문항수, 평가요소(elements), 시험문제들(문항점수포함)
        return new ExamResponse.ExamStartDTO(paperPS, studentName, subjectElementListPS, questionListPS);
    }

    public ExamResponse.MyPaperListDTO 나의시험목록(Long sessionUserId){
        User userPS = userRepository.findByStudent(sessionUserId)
                .orElseThrow(() -> new Exception404("당신은 학생이 아니에요 : 관리자에게 문의하세요."));

        Course coursePS = userPS.getStudent().getCourse();

        List<Paper> papers = paperRepository.findByCourseId(coursePS.getId());

        return new ExamResponse.MyPaperListDTO(userPS.getStudent().getId(), papers);
    }

    @Transactional
    public void 시험결과저장(ExamRequest.SaveDTO reqDTO, User sessionUser) {
        // 1. Exam 저장
        Paper paper = paperRepository.findById(reqDTO.getPaperId())
                .orElseThrow(() -> new Exception404("시험지를 찾을 수 없어요"));

        Student student = studentRepository.findByUserId(sessionUser.getId());

        Exam exam = reqDTO.toEntity(paper, student, "통과", 80, 4);
        
        // 2. ExamAnswer 컬렉션 저장
    }
}
