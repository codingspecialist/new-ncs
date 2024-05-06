package shop.mtcoding.blog.course.exam;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.paper.Paper;

import java.time.LocalDateTime;

/**
 * 1. 실행된 시험
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "exam_tb")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 시험 보는 학생
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    // 시험 담당 강사
    private String teacherName;

    // 시험지
    @ManyToOne(fetch = FetchType.LAZY)
    private Paper paper;

    // 결석여부
    private boolean isAbsent;

    private String examState; // 본평가, 재평가
    private String passState; // 통과, 미통과, 평가포기

    private Integer score; // 시험결과 점수
    private Integer grade; // 시험결과 수준

    @CreationTimestamp
    private LocalDateTime createDate;

    public void updatePointAndGrade(Integer score){
        this.score = score;
        if(score >= 90){
            grade = 5;
        }else if(score >= 80){
            grade = 4;
        }else if(score >= 70){
            grade = 3;
        }else if(score >= 60){
            grade = 2;
        }else{
            grade = 1;
        }

        if(grade > 1){
            passState = "통과";
        }else{
            passState = "미통과";
        }
    }

    @Builder
    public Exam(Long id, Student student, String teacherName, Paper paper, boolean isAbsent, String examState, String passState, Integer score, Integer grade, LocalDateTime createDate) {
        this.id = id;
        this.student = student;
        this.teacherName = teacherName;
        this.paper = paper;
        this.isAbsent = isAbsent;
        this.examState = examState;
        this.passState = passState;
        this.score = score;
        this.grade = grade;
        this.createDate = createDate;
    }
}
