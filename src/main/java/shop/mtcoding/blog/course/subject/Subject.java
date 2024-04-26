package shop.mtcoding.blog.course.subject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.Course;

import java.time.LocalDateTime;

/**
 * 1. 교과목 정보 (자바, 스프링)
 * 2. 교과목 세부 수업 내용은 SubjectUnit 기입
 * 3. 해당 교과목은 2회차 시행시에 불러오기 해서 특정 정보만 변경해서 저장할 수 있다.
 */
@NoArgsConstructor
@Getter
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code; // 능력단위코드
    private String name; // 능력단위명
    private String purpose; // 훈련목표
    private String gubun; // NCS, 비NCS
    private Integer grade; // 수준
    private Integer totalTime; // 능력단위 시간

    private Integer no; // 과정에서 몇번째로 시작하는 교과목인지에 대한 연번
    private String learningWay; // 학습 방법
    private String evaluationWay; // 평가 방법
    private LocalDateTime evaluationDate; // 평가일
    private LocalDateTime revaluationDate; // 재평가일
    private LocalDateTime evaluationScheduleDate; // 평가 예정일
    private LocalDateTime revaluationScheduleDate; // 재평가 예정일
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // 코스에 회차 정보가 있기 때문에 특정 회차에 대한 교과목이다. 다음 회차에서 적기 귀찮으면 불러오기 해서 저장할 수 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @CreationTimestamp
    private LocalDateTime createDate;
}
