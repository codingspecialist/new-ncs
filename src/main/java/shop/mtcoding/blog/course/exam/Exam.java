package shop.mtcoding.blog.course.exam;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.exam.paper.ExamPaper;
import shop.mtcoding.blog.course.student.Student;

import java.time.LocalDateTime;

/**
 * 1. 실행된 시험
 */
@NoArgsConstructor
@Getter
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExamPaper examPaper;

    private boolean isAbsent;

    private String examState; // 본평가, 재평가
    private String passState; // 통과, 미통과, 평가포기

    @CreationTimestamp
    private LocalDateTime createDate;
}
