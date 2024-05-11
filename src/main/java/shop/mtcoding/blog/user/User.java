package shop.mtcoding.blog.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.student.Student;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String name; // 선생님 이름 or 학생 이름

    @Lob
    private String sign; // 선생님이라면 서명 (base64 저장)
    private String role; // student, teacher
    private Boolean isTeacher;
    private Boolean isCheck; // 인증 여부

    @CreationTimestamp // pc -> db (날짜주입)
    private Timestamp createdAt;

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    // @Column(unique = true) // OneToOne은 UK가 기본적용됨.
    @OneToOne(fetch = FetchType.LAZY)
    private Student student; // role이 student이면 연결된 객체 필요!! 선생이 먼저 학생을 등록해야 가입가능

    @Builder
    public User(Long id, String username, String password, String email, String name, String sign, String role, Boolean isTeacher, Boolean isCheck, Timestamp createdAt, Student student) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.sign = sign;
        this.role = role;
        this.isTeacher = isTeacher;
        this.isCheck = isCheck;
        this.createdAt = createdAt;
        this.student = student;
    }
}
