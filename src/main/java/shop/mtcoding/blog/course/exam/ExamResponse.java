package shop.mtcoding.blog.course.exam;

import lombok.Data;
import shop.mtcoding.blog.paper.Paper;

public class ExamResponse {

    @Data
    public static class MyPaperDTO {
        private Long paperId;

        private String courseTitle;
        private Integer courseRound;
        private Long subjectId;
        private String subjectTitle; // 교과목명
        private Integer count; // 문항수

        public MyPaperDTO(Paper paper) {
            this.paperId = paper.getId();
            this.courseTitle = paper.getSubject().getCourse().getTitle();
            this.courseRound = paper.getSubject().getCourse().getRound();
            this.subjectId = paper.getSubject().getId();
            this.subjectTitle = paper.getSubject().getTitle();
            this.count = paper.getCount();
        }
    }
}
