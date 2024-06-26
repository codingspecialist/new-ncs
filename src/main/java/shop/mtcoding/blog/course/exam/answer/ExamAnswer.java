package shop.mtcoding.blog.course.exam.answer;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.mtcoding.blog.course.exam.Exam;
import shop.mtcoding.blog.paper.question.Question;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "exam_answer_tb")
public class ExamAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exam exam; // 시험지 1개 - 시험은 25개(학생수만큼)

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question; // 시험지 1개 - 시험문제 20개(문제수만큼)

    private Integer questionNo;
    private Integer selectedOptionNo;
    private Boolean isCorrect; // true이면 맞춘거임

    public void update(Integer selectedOptionNo, Boolean isCorrect){
        this.selectedOptionNo = selectedOptionNo;
        this.isCorrect = isCorrect;
    }

    @Builder
    public ExamAnswer(Long id, Exam exam, Question question, Integer questionNo, Integer selectedOptionNo, Boolean isCorrect) {
        this.id = id;
        this.exam = exam;
        this.question = question;
        this.questionNo = questionNo;
        this.selectedOptionNo = selectedOptionNo;
        this.isCorrect = isCorrect;
    }
}
