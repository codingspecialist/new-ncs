package shop.mtcoding.blog.course.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception404;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.course.student.StudentRepository;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.course.subject.SubjectRepository;
import shop.mtcoding.blog.paper.Paper;
import shop.mtcoding.blog.paper.PaperRepository;
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

    public void 시험지목록(Long sessionUserId){
        User userPS = userRepository.findByStudent(sessionUserId)
                .orElseThrow(() -> new Exception404("유저를 찾을 수 없어요"));

        Long courseId = userPS.getStudent().getCourse().getId();

        List<Subject> subjects = subjectRepository.findByCourseId(courseId);
    }
}
