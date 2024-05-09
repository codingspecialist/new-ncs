package shop.mtcoding.blog.course.exam;

import lombok.Data;
import shop.mtcoding.blog._core.errors.exception.api.ApiException400;
import shop.mtcoding.blog.course.exam.answer.ExamAnswer;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.paper.Paper;
import shop.mtcoding.blog.paper.question.Question;

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
            private Integer selectedOptionNo; // 정답 번호 (PK 아님)

            // 채점하기
            public ExamAnswer toEntity(Question question, Exam exam) {
                if (selectedOptionNo == null) throw new ApiException400("모든 문제에 대한 답안을 제출해야 됩니다");

                boolean isCollect;
                if (question.getAnswerNumber() == selectedOptionNo) {
                    isCollect = true;
                } else {
                    isCollect = false;
                }

                ExamAnswer examAnswer = ExamAnswer.builder()
                        .exam(exam)
                        .question(question)
                        .questionNo(questionNo)
                        .selectedOptionNo(selectedOptionNo)
                        .isCorrect(isCollect)
                        .build();

                return examAnswer;
            }

        }

        public Exam toEntity(Paper paper, Student student, String passState, Double score, Integer grade, String reExamReason) {
            return Exam.builder()
                    .paper(paper)
                    .student(student)
                    .teacherName(teacherName)
                    .passState(passState)
                    .score(score)
                    .grade(grade)
                    .examState(paper.getPaperState())
                    .reExamReason(reExamReason)
                    .build();
        }
    }

}
