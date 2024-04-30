package shop.mtcoding.blog.course.paper.question.option;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.paper.question.PaperQuestion;

import java.time.LocalDateTime;

/**
 * 시험문제의 옵션 4가지 항목
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "paper_question_option_tb")
public class PaperQuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer no; // 시험문제의 4지선답 번호
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private PaperQuestion paperQuestion;

    @CreationTimestamp
    private LocalDateTime createDate;

    @Builder
    public PaperQuestionOption(Long id, Integer no, String content, PaperQuestion paperQuestion, LocalDateTime createDate) {
        this.id = id;
        this.no = no;
        this.content = content;
        this.paperQuestion = paperQuestion;
        this.createDate = createDate;
    }
}
