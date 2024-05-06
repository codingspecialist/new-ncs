package shop.mtcoding.blog.course.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    Optional<Exam> findByPaperIdAndStudentId(@Param("paperId") Long paperId, @Param("studentId") Long studentId);
}
