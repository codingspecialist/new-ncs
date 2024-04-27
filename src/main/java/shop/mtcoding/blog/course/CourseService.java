package shop.mtcoding.blog.course;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception404;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.course.subject.SubjectRepository;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CourseService {
    private final SubjectRepository subjectRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public void 과정등록(CourseRequest.SaveDTO reqDTO){
        courseRepository.save(reqDTO.toEntity());
    }

    public CourseResponse.PagingDTO 과정목록(Pageable pageable) {
        Page<Course> paging = courseRepository.findAll(pageable);
        return new CourseResponse.PagingDTO(paging);
    }

    public CourseResponse.DetailDTO 과정상세(Long courseId, Pageable pageable) {
        Course coursePS = courseRepository.findById(courseId)
                .orElseThrow(() -> new Exception404("과정을 찾을 수 없습니다"));

        Page<Subject> paging = subjectRepository.findByCourseId(coursePS.getId(), pageable);
        return new CourseResponse.DetailDTO(coursePS, paging);
    }
}
