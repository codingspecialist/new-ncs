package shop.mtcoding.blog.course;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public class CourseResponse {

    // 기본 응답 DTO
    @Data
    public static class DTO {
        private Long id;
        private String title;
        private String code;
        private Integer totalTime;
        private Integer totalDay;
        private Integer round;
        private LocalDate startDate;
        private LocalDate endDate;
        private String teacherName;

        public DTO(Course course) {
            this.id = course.getId();
            this.title = course.getTitle();
            this.code = course.getCode();
            this.totalTime = course.getTotalTime();
            this.totalDay = course.getTotalDay();
            this.round = course.getRound();
            this.startDate = course.getStartDate();
            this.endDate = course.getEndDate();
            this.teacherName = course.getTeacherName();
        }
    }

    @Data
    public static class Paging {
        private Integer totalPage; // 전체 페이지 수
        private Integer pageSize; // 페이지 별 아이템 개수
        private Integer pageNumber; // 현재 페이지 번호
        private Boolean isFirst; // 첫번째 페이지 여부
        private Boolean isLast; // 마지막 페이지 여부
        private List<DTO> courses;

        public Paging(Page<Course> coursePG) {
            this.totalPage = coursePG.getTotalPages();
            this.pageSize = coursePG.getSize();
            this.pageNumber = coursePG.getNumber();
            this.isFirst = coursePG.isFirst();
            this.isLast = coursePG.isLast();
            this.courses = coursePG.getContent().stream().map(DTO::new).toList();
        }
    }
}
