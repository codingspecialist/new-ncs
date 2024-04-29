package shop.mtcoding.blog.course.subject.element;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectElementRepository extends JpaRepository<SubjectElement, Long> {

    @Query("select se from SubjectElement se where se.subject.id = :subjectId")
    List<SubjectElement> findBySubjectId(Long subjectId);
}
