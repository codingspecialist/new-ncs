package shop.mtcoding.blog.course.subject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@DataJpaTest
public class SubjectRepositoryTest {
    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void findByCourseId_test(){
        Long courseId = 1L;

        subjectRepository.findByCourseId(courseId);
    }

}
