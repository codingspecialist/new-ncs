package shop.mtcoding.blog.course.exam;

import lombok.Data;
import shop.mtcoding.blog.paper.Paper;

import java.util.List;

public class ExamResponse {

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
