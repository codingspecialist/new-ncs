package shop.mtcoding.blog.paper.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("select q from Question q join fetch q.questionOptions op where q.paper.id = :paperId")
    List<Question> findByPaperId(@Param("paperId") Long paperId);
}