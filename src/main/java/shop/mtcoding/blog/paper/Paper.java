package shop.mtcoding.blog.paper;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.subject.Subject;

import java.time.LocalDateTime;

/**
 * 1. 시험지는 순수해야 한다. 연관관계를 맺지 말자.
 * 2. 시험이 연관관계를 가져야 한다.
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "paper_tb")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 하나의 시험지는 하나의 과정에 하나의 교과목에서만 사용될 수 있다.
    // 그런데 과정은 2회차가 있기 때문에 그 회차에도 사용되어야 한다.
    // 시험지는 한개 만들어서 공유해서 쓰면 된다.
    // 시험지 자체가 시험을 실행하는 엔티티는 아니기 때문이다.
    // 시험을 실행하는 엔티티는 Exam이다.
    // 만약 시험지를 시험을 실행하는 엔티티로 쓰게 되면, 미리 만들어둘 수가 없다.
    // 학생과 과정이 있고, 교과목이 있는 상태에서, 시험지를 교과목에 학생수만큼 new해서
    // 만들어둬야 한다.
    // 그럼 시험을 친다는 것은 시험지를 업데이트 하는 방식이 되어야 한다.
    // 어떤 방식이 좋을까?

    // @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject; // Subject(정보들), SubjectElement(subtitles)

    private Integer count; // 문항수
    private String paperState; // 본평가지, 재평가지

    @CreationTimestamp
    private LocalDateTime createDate;

    @Builder
    public Paper(Long id, Subject subject, Integer count, String paperState, LocalDateTime createDate) {
        this.id = id;
        this.subject = subject;
        this.count = count;
        this.paperState = paperState;
        this.createDate = createDate;
    }
}
