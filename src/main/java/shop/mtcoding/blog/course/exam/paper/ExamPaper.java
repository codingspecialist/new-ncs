package shop.mtcoding.blog.course.exam.paper;

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
public class ExamPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @CreationTimestamp
    private LocalDateTime createDate;

    @Builder
    public ExamPaper(Long id, Subject subject, LocalDateTime createDate) {
        this.id = id;
        this.subject = subject;
        this.createDate = createDate;
    }
}
