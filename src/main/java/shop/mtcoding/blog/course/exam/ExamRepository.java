package shop.mtcoding.blog.course.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query("select ex.id from Exam ex where ex.student.studentNo = :nextStudentNo and ex.paper.subject.id = :subjectId")
    Long findByStudentNoNextExamId(@Param("subjectId") Long subjectId, @Param("nextStudentNo") Integer nextStudentNo);

    @Query("select ex.id from Exam ex where ex.student.studentNo = :prevStudentNo and ex.paper.subject.id = :subjectId")
    Long findByStudentNoPrevExamId(@Param("subjectId") Long subjectId, @Param("prevStudentNo") Integer prevStudentNo);

    @Query("select ex from Exam ex join fetch ex.paper p join fetch ex.student st where ex.paper.subject.id = :subjectId order by st.studentNo asc")
    List<Exam> findBySubjectId(@Param("subjectId") Long subjectId);

    @Query("select ex from Exam ex where ex.paper.subject.id = :subjectId and ex.student.id = :studentId")
    Optional<Exam> findByOrigin(@Param("subjectId") Long subjectId, @Param("studentId") Long studentId);

    @Query("select ex from Exam ex join fetch ex.paper p join fetch ex.student st where ex.student.id = :studentId order by p.subject.no asc")
    List<Exam> findByStudentId(@Param("studentId") Long studentId);

    Optional<Exam> findByPaperIdAndStudentId(@Param("paperId") Long paperId, @Param("studentId") Long studentId);

    @Query("select ex from Exam ex join fetch ex.examAnswers an join fetch an.question q join fetch q.questionOptions op where ex.id = :examId")
    Optional<Exam> findByIdWithAnswer(@Param("examId") Long examId);
}
