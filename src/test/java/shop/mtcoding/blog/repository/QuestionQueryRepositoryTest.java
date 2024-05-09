package shop.mtcoding.blog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.paper.PaperRepository;
import shop.mtcoding.blog.paper.question.QuestionDBResponse;
import shop.mtcoding.blog.paper.question.QuestionQueryRepository;

@Import(QuestionQueryRepository.class)
@DataJpaTest
public class QuestionQueryRepositoryTest {

    @Autowired
    private QuestionQueryRepository questionQueryRepository;

    @Test
    public void findStatisticsByPaperId_test(){
        // given
        Long paperId = 1L;

        // when
        QuestionDBResponse.ExpectedNextDTO respDTO = questionQueryRepository.findStatisticsByPaperId(paperId);

        // eye
        System.out.println(respDTO);

        // then
    }
}
