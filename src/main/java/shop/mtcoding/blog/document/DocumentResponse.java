package shop.mtcoding.blog.document;

import lombok.Data;
import shop.mtcoding.blog._core.utils.MyUtil;
import shop.mtcoding.blog.course.Course;
import shop.mtcoding.blog.course.subject.Subject;

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
}
