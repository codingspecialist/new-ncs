package shop.mtcoding.blog.course.exam;

import lombok.Data;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.paper.Paper;

import java.util.List;

// request 내부 클래스는 public static 으로 만든다.
public class ExamRequest {

    @Data
    public static class SaveDTO {
        private Long paperId;
        private String teacherName;
        private List<AnswerDTO> answers;

        @Data
        public static class AnswerDTO {
            private Integer questionNo; // 문제 번호 (PK 아님)
            private Integer optionNo; // 정답 번호 (PK 아님)

        }

        public Exam toEntity(Paper paper, Student student, String passState, Integer point, Integer grade){
            return Exam.builder()
                    .paper(paper)
                    .student(student)
                    .teacherName(teacherName)
                    .passState(passState)
                    .point(point)
                    .grade(grade)
                    .examState("본평가")
                    .isAbsent(false)
                    .build();
        }
    }
    
}
