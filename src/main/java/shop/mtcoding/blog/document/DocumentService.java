package shop.mtcoding.blog.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.course.Course;
import shop.mtcoding.blog.course.CourseRepository;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.course.subject.SubjectRepository;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DocumentService {

    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;

    public List<DocumentResponse.CourseDTO> 과정목록(){
        List<Course> courseListPS =  courseRepository.findAll();
        return courseListPS.stream().map(DocumentResponse.CourseDTO::new).toList();
    }

    public List<DocumentResponse.SubjectDTO> 교과목목록(Long courseId) {
        List<Subject> subjectListPS = subjectRepository.findByCourseId(courseId);
        return subjectListPS.stream().map(DocumentResponse.SubjectDTO::new).toList();
    }

    public DocumentResponse.No1DTO no1() {
        return null;
    }
}
