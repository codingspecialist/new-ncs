package shop.mtcoding.blog.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.student st where u.id = :userId")
    Optional<User> findByStudent(@Param("userId") Long userId);

    @Query("select u from User u left join fetch u.student st where u.username = :username and u.password = :password")
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    Optional<User> findByUsername(@Param("username") String username);

    @Query("select u from User u where u.name = :teacherName")
    Optional<User> findByTeacherName(@Param("teacherName") String teacherName);
}