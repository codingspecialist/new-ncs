package shop.mtcoding.blog.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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
    private String name;
    private String code; // 과정ID
    private Integer totalTime; // 훈련시간
    private Integer totalDays; // 훈련일수
    private Integer round; // 1회차, 2회차
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isLesson; // 종료된 과정(false), 실시중 과정(true)

    @CreationTimestamp
    private LocalDateTime createDate;
}
