package shop.mtcoding.blog.course;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 1. 크로스플랫폼 과정에 특정 회차 정보
 * 2. 새로운 코스를 등록할 때 해당 Course 정보를 불러오기 할 수 있다.
 */
@NoArgsConstructor
@Getter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code; // 과정ID
    private Integer totalTime; // 훈련시간
    private Integer totalDay; // 훈련일수
    private Integer round; // 1회차, 2회차
    private LocalDate startDate; // 년월일
    private LocalDate endDate; // 년월일
    private String teacherName; // 훈련교사 이름

    @Enumerated(EnumType.STRING)
    private CourseEnum courseStatus; // 과정진행전, 과정진행중, 과정종료 (기본값은 과정진행전이다 - 숫자로는 0번)

    @CreationTimestamp
    private LocalDateTime createDate;

    @Builder
    public Course(Long id, String title, String code, Integer totalTime, Integer totalDay, Integer round, LocalDate startDate, LocalDate endDate, String teacherName, CourseEnum courseStatus, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.totalTime = totalTime;
        this.totalDay = totalDay;
        this.round = round;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherName = teacherName;
        this.courseStatus = courseStatus;
        this.createDate = createDate;
    }
}
