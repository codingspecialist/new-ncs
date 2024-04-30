package shop.mtcoding.blog.course.exam.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.mtcoding.blog.course.exam.Exam;
import shop.mtcoding.blog.course.paper.question.PaperQuestion;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "exam_answer_tb")
public class ExamAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Exam exam; // 시험지 1개 - 시험은 25개(학생수만큼)

    @ManyToOne
    private PaperQuestion question; // 시험지 1개 - 시험문제 20개(문제수만큼)

    private Integer submitAnswerNumber;
    private Boolean isCorrect; // true이면 맞춘거임
}
