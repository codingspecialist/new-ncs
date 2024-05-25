package shop.mtcoding.blog.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception404;
import shop.mtcoding.blog.course.Course;
import shop.mtcoding.blog.course.CourseRepository;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.course.subject.SubjectRepository;
import shop.mtcoding.blog.paper.Paper;
import shop.mtcoding.blog.paper.PaperRepository;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.QuestionRepository;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DocumentService {

    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;
    private final PaperRepository paperRepository;

    public List<DocumentResponse.CourseDTO> 과정목록(){
        List<Course> courseListPS =  courseRepository.findAll();
        return courseListPS.stream().map(DocumentResponse.CourseDTO::new).toList();
    }

    public List<DocumentResponse.SubjectDTO> 교과목목록(Long courseId) {
        List<Subject> subjectListPS = subjectRepository.findByCourseId(courseId);
        return subjectListPS.stream().map(DocumentResponse.SubjectDTO::new).toList();
    }

    public DocumentResponse.No1DTO no1(Long subjectId) {
        Subject subjectPS = subjectRepository.findById(subjectId).orElseThrow(
                () -> new Exception404("해당 교과목이 없어요")
        );
        Paper paperPS = paperRepository.findBySubjectIdAndPaperState(subjectId, "본평가");
        List<Question> questionListPS = questionRepository.findByPaperId(paperPS.getId());
        return new DocumentResponse.No1DTO(subjectPS, questionListPS);
    }
}
