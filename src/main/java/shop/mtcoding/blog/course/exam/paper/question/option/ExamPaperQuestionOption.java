package shop.mtcoding.blog.course.exam.paper.question.option;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.exam.paper.question.ExamPaperQuestion;

import java.time.LocalDateTime;

/**
 * 시험문제의 옵션 4가지 항목
 */
@NoArgsConstructor
@Getter
@Entity
public class ExamPaperQuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer no; // 시험문제의 4지선답 번호
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExamPaperQuestion examPaperQuestion;

    @CreationTimestamp
    private LocalDateTime createDate;
}
