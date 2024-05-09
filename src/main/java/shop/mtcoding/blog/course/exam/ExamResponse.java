package shop.mtcoding.blog.course.exam;

import lombok.Data;
import shop.mtcoding.blog.course.subject.element.SubjectElement;
import shop.mtcoding.blog.paper.Paper;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.option.QuestionOption;

import java.util.List;
import java.util.Map;

public class ExamResponse {
    // PK, 번호(교과목번호), 과정명/회차, paper.getSubject(교과목), 시험유형, 학생명, 훈련강사, 결과점수, 통과여부, (통과못했거나, 재평가지로 재평가하기버튼필요)
    @Data
    public static class ResultDTO {
        private Long examId;
        private Integer subjectNo;
        private String courseNameAndRound;
        private String subjectTitle;
        private String paperState;
        private String studentName;
        private String teacherName;
        private Double examScore;
        private String examPassState;
        private String reExamReason;
        private Boolean isNotPass;

        public ResultDTO(Exam exam) {
            this.examId = exam.getId();
            this.subjectNo = exam.getPaper().getSubject().getNo();
            this.courseNameAndRound = exam.getStudent().getCourse().getTitle() + "/" + exam.getStudent().getCourse().getRound() +"회차";
            this.subjectTitle = exam.getPaper().getSubject().getTitle();
            this.paperState = exam.getPaper().getPaperState();
            this.studentName = exam.getStudent().getName();
            this.teacherName = exam.getTeacherName();
            this.examScore = exam.getScore();
            this.examPassState = exam.getPassState();
            this.reExamReason = "/본평가 "+exam.getReExamReason();
            this.isNotPass = exam.getScore() >= 60 ? false : true;
        }
    }

    @Data
    public static class StartDTO {
        private Long paperId;
        private String studentName;
        private String teacherName;
        private String evaluationDate; // 평가일 (subject)
        private String loc; // 평가장소 (임시)
        private String subjectTitle; // 교과목 (subject)
        private List<String> subjectElements;
        private List<QuestionDTO> questions;
        private Integer questionCount;

        public StartDTO(Paper paper, String studentName, List<SubjectElement> subjectElements, List<Question> questions) {
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

        public MyPaperListDTO(Long studentId, List<Paper> papers, Map<Long, Boolean> attendanceMap) {
            this.studentId = studentId;
            this.papers = papers.stream().map(paper -> {

                Boolean isAttendance =  attendanceMap.get(paper.getId());

                return new PaperDTO(paper, isAttendance);
            }).toList();
        }

        @Data
        class PaperDTO {
            private Long paperId;
            private String courseTitle;
            private Integer courseRound;
            private Long subjectId;
            private String subjectTitle; // 교과목명
            private Integer count; // 문항수
            private String paperState;
            private String teacherName;
            private Boolean isAttendance;

            public PaperDTO(Paper paper, Boolean isAttendance) {
                this.paperId = paper.getId();
                this.courseTitle = paper.getSubject().getCourse().getTitle();
                this.courseRound = paper.getSubject().getCourse().getRound();
                this.subjectId = paper.getSubject().getId();
                this.subjectTitle = paper.getSubject().getTitle();
                this.count = paper.getCount();
                this.paperState = paper.getPaperState();
                this.teacherName = paper.getSubject().getTeacherName();
                this.isAttendance = isAttendance;
            }
        }


    }
}
