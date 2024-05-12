package shop.mtcoding.blog.course.student;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.Course;
import shop.mtcoding.blog.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "student_tb")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 학생 번호는 이름순으로 해서 rownum 뽑자
    private String birthday;

    @Enumerated(EnumType.STRING)
    private StudentEnum state; // 취업, 중도탈락, 미이수, 이수, 재학중
    private LocalDate dropOutDate; // 중탈 날짜
    private String dropOutReason; // 중탈 이유
    private String comment; // 학생 모든 교과목에 대한 총평
    private Integer grade; // 학생 모든 교과목에 대한 수준 1,2,3,4,5

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    private Integer studentNo; // 교과목 1에 학생번호 1 (유니크 복합키)

    // 조회 용도로만 사용
    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    private User user;

    @CreationTimestamp
    private LocalDateTime createDate;

    // 학생이 입력될 때 마다 자동으로 이름순으로 번호 업데이트
    public void updateStudentNo(Integer studentNo){
        this.studentNo = studentNo;
    }

    @Builder
    public Student(Long id, String name, String birthday, StudentEnum state, LocalDate dropOutDate, String dropOutReason, String comment, Integer grade, Course course, Integer studentNo, User user, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.state = state;
        this.dropOutDate = dropOutDate;
        this.dropOutReason = dropOutReason;
        this.comment = comment;
        this.grade = grade;
        this.course = course;
        this.studentNo = studentNo;
        this.user = user;
        this.createDate = createDate;
    }
}
