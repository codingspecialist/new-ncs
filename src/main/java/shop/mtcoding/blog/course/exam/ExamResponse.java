package shop.mtcoding.blog.course.exam;

import lombok.Data;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.course.subject.element.SubjectElement;
import shop.mtcoding.blog.paper.Paper;
import shop.mtcoding.blog.paper.PaperResponse;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.option.QuestionOption;

import java.util.List;

public class ExamResponse {

    @Data
    public static class ExamStartDTO {
        private Long paperId;
        private String studentName;
        private String teacherName;
        private String evaluationDate; // 평가일 (subject)
        private String loc; // 평가장소 (임시)
        private String subjectTitle; // 교과목 (subject)
        private List<String> subjectElements;
        private List<QuestionDTO> questions;
        private Integer questionCount;

        public ExamStartDTO(Paper paper, String studentName, List<SubjectElement> subjectElements, List<Question> questions) {
            this.paperId = paper.getId();
            this.studentName = studentName;
            this.teacherName = paper.getSubject().getTeacherName();
            this.evaluationDate = paper.getSubject().getEvaluationDate().toString();
            this.loc = "3호";
            this.subjectTitle = paper.getSubject().getTitle();
            this.subjectElements = subjectElements.stream().map(se -> se.getSubtitle()).toList();
            this.questions = questions.stream().map(QuestionDTO::new).toList();
            this.questionCount = questions.size();
        }

        @Data
        class QuestionDTO {
            private Long questionId;
            private Integer no;
            private String title;
            private Integer point;
            private List<OptionDTO> options;

            public QuestionDTO(Question question) {
                this.questionId = question.getId();
                this.no = question.getNo();
                this.title = question.getTitle();
                this.point = question.getPoint();
                this.options = question.getQuestionOptions().stream().map(OptionDTO::new).toList();
            }

            @Data
            class OptionDTO {
                private Long optionId;
                private Integer no;
                private String content;

                public OptionDTO(QuestionOption option) {
                    this.optionId = option.getId();
                    this.no = option.getNo();
                    this.content = option.getContent();
                }
            }
        }
    }


    @Data
    public static class MyPaperListDTO {

        private Long studentId;
        private List<PaperDTO> papers;

        public MyPaperListDTO(Long studentId, List<Paper> papers) {
            this.studentId = studentId;
            this.papers = papers.stream().map(PaperDTO::new).toList();
        }

        @Data
        class PaperDTO {
            private Long paperId;
            private String courseTitle;
            private Integer courseRound;
            private Long subjectId;
            private String subjectTitle; // 교과목명
            private Integer count; // 문항수
            private String teacherName;

            public PaperDTO(Paper paper) {
                this.paperId = paper.getId();
                this.courseTitle = paper.getSubject().getCourse().getTitle();
                this.courseRound = paper.getSubject().getCourse().getRound();
                this.subjectId = paper.getSubject().getId();
                this.subjectTitle = paper.getSubject().getTitle();
                this.count = paper.getCount();
                this.teacherName = paper.getSubject().getTeacherName();
            }
        }


    }
}
