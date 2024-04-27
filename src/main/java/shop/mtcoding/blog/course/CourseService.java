package shop.mtcoding.blog.course;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public void 과정등록(CourseRequest.SaveDTO reqDTO){
        Course coursePS = courseRepository.save(reqDTO.toEntity());
    }

    public CourseResponse.Paging 과정목록(Pageable pageable) {
        Page<Course> coursePG = courseRepository.findAll(pageable);
        return new CourseResponse.Paging(coursePG);
    }
}
