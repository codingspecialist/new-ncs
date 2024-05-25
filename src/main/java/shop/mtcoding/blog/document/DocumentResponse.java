package shop.mtcoding.blog.document;

import lombok.Data;
import shop.mtcoding.blog._core.utils.MyUtil;
import shop.mtcoding.blog.course.Course;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.option.QuestionOption;

import java.util.Arrays;
import java.util.List;

public class DocumentResponse {

    @Data
    public static class CourseDTO {
        private Long courseId;
        private String courseTitle;
        private Integer courseRound;
        private String courseStartDate;

        public CourseDTO(Course course) {
            this.courseId = course.getId();
            this.courseTitle = course.getTitle();
            this.courseRound = course.getRound();
            this.courseStartDate = MyUtil.localDateToString(course.getStartDate());
        }
    }

    @Data
    public static class SubjectDTO {
        private Long subjectId;
        private Integer subjectNo; // 화면에 사용될 번호
        private String subjectTitle;

        public SubjectDTO(Subject subject) {
            this.subjectId = subject.getId();
            this.subjectNo = subject.getNo();
            this.subjectTitle = subject.getTitle();
        }
    }

    @Data
    public static class No1DTO {
        private String courseTitle;
        private Integer courseRound;
        private String courseStartDate;
        private String courseEndDate;
        private String subjectTitle;
        private String subjectEvaluationWay;
        private String subjectTeacherName;
        private String subjectEvaluationDate; // 채점일시 == 평가일시 == 제출기한
        private String loc;
        private List<String> subjectElements;
        private String submitWay; // 제출방법 : 온라인
        private List<String> examRates; // 평가 배점 (1차, 2차), 결시자는 2차 평가와 같다.
        private String equipment; // 평가환경 장비
        private List<QuestionDTO> questions;

        // 교과목 조회, 교과목의 본평가 시험지로 출제된 문제 목록 조회
        public No1DTO(Subject subject, List<Question> questions) {
            this.courseTitle = subject.getCourse().getTitle();
            this.courseRound = subject.getCourse().getRound();
            this.courseStartDate = subject.getCourse().getStartDate().toString();
            this.courseEndDate = MyUtil.localDateToString(subject.getCourse().getEndDate());
            this.subjectTitle = subject.getTitle();
            this.subjectEvaluationWay = subject.getEvaluationWay();
            this.subjectTeacherName = subject.getTeacherName();
            this.subjectEvaluationDate = MyUtil.localDateToString(subject.getEvaluationDate());
            this.loc = "3호";
            this.subjectElements = subject.getElements().stream().map(subjectElement -> subjectElement.getSubtitle()).toList();
            this.submitWay = "온라인 제출";
            this.examRates = Arrays.asList("본평가 배점 : 평가점수 X 100%", "재평가 배점 : 평가점수 X 90%", "결시자 배점 : 평가점수 X 90%");
            this.equipment = "인터넷이 설치되어 있는 PC";
            this.questions = questions.stream().map(QuestionDTO::new).toList();
        }

        @Data
        class QuestionDTO {
            private Integer no;
            private String title;
            private Integer point;
            private Integer answerNumber;
            private List<OptionDTO> options;

            public QuestionDTO(Question question) {
                this.no = question.getNo();
                this.title = question.getTitle();
                this.point = question.getPoint();
                this.answerNumber = question.getAnswerNumber();
                this.options = question.getQuestionOptions().stream().map(OptionDTO::new).toList();;
            }

            @Data
            class OptionDTO {
                private Integer no;
                private String content;
                private Boolean isRight;

                public OptionDTO(QuestionOption option) {
                    this.no = option.getNo();
                    this.content = option.getContent();
                    this.isRight = option.getIsRight();
                }
            }
        }
    }
}
