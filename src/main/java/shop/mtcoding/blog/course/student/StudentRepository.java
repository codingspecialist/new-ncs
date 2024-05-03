package shop.mtcoding.blog.course.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select st from Student st where st.course.id = :courseId")
    List<Student> findByCourseId(@Param("courseId") Long courseId);

    Student findByNameAndBirthday(@Param("name") String name, @Param("courseId") String courseId);

    Student findByUserId(@Param("userId") Long userId);
}
