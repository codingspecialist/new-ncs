package shop.mtcoding.blog.course.exam.paper.question;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.exam.paper.ExamPaper;

import java.time.LocalDateTime;

/**
 * 시험지에 종속된 문제
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "exam_paper_question_tb")
public class ExamPaperQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer no; // 시험지에 종속되는 시험 순서 1, 2, 3
    private String title; // 시험 문제 제목
    private Integer point; // 시험 문제 점수 10점, 20점
    private Integer answerNumber; // 4번이 정담

    @ManyToOne(fetch = FetchType.LAZY)
    private ExamPaper examPaper;

    @CreationTimestamp
    private LocalDateTime createDate;

    @Builder
    public ExamPaperQuestion(Long id, Integer no, String title, Integer point, Integer answerNumber, ExamPaper examPaper, LocalDateTime createDate) {
        this.id = id;
        this.no = no;
        this.title = title;
        this.point = point;
        this.answerNumber = answerNumber;
        this.examPaper = examPaper;
        this.createDate = createDate;
    }
}