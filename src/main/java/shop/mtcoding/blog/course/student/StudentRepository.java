package shop.mtcoding.blog.course.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select st from Student st where st.course.id = :courseId")
    List<Student> findByCourseId(Long courseId);
}