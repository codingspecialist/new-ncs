package shop.mtcoding.blog.course.student;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "student_tb")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer no; // 해당 과정에서의 번호 (25명 학생중에 1번)
    private String name;
    private String birthday;
    private String state; // 취업, 중도탈락, 미이수, 이수, 재학중
    private LocalDateTime dropOutDate; // 중탈 날짜
    private String dropOutReason; // 중탈 이유
    private String comment; // 학생 모든 교과목에 대한 총평
    private Integer grade; // 학생 모둔 교과목에 대한 수준 1,2,3,4,5

    @CreationTimestamp
    private LocalDateTime createDate;

    @Builder
    public Student(Long id, Integer no, String name, String birthday, String state, LocalDateTime dropOutDate, String dropOutReason, String comment, Integer grade, LocalDateTime createDate) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.birthday = birthday;
        this.state = state;
        this.dropOutDate = dropOutDate;
        this.dropOutReason = dropOutReason;
        this.comment = comment;
        this.grade = grade;
        this.createDate = createDate;
    }
}