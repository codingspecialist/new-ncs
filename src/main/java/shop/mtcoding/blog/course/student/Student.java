package shop.mtcoding.blog.course.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
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
}
