package shop.mtcoding.blog.course.exam;

import lombok.Data;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.paper.Paper;

import java.util.List;

public class ExamRequest {

    @Data
    public static class SaveDTO {
        private Long paperId;
        private String teacherName;
        private List<AnswerDTO> answers;

        @Data
        class AnswerDTO {
            private Long questionNo; // 문제 번호 (PK 아님)
            private Long selectNo; // 정답 번호 (PK 아님)
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
