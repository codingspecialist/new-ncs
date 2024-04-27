package shop.mtcoding.blog.course.subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("select s from Subject s where s.course.id = :courseId")
    Page<Subject> findByCourseId(@Param("courseId") Long courseId, @Param("pageable") Pageable pageable);
}
