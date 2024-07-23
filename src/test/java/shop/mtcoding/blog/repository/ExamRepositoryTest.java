package shop.mtcoding.blog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.blog.course.exam.ExamRepository;
import shop.mtcoding.blog.paper.PaperRepository;

@DataJpaTest
public class ExamRepositoryTest {

    @Autowired
    private ExamRepository examRepository;

    @Test
    public void findByOrigin_test(){
        // given

        // when
        //examRepository.findByOrigin(1L,2L);

        // then
    }
}
