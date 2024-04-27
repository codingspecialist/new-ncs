package shop.mtcoding.blog.course;

import lombok.Data;

import java.time.LocalDate;

public class CourseRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String code;
        private Integer totalTime;
        private Integer totalDay;
        private Integer round;
        private LocalDate startDate;
        private LocalDate endDate;
        private String teacherName;

        public Course toEntity(){
            return Course.builder()
                    .title(title)
                    .code(code)
                    .totalTime(totalTime)
                    .totalDay(totalDay)
                    .round(round)
                    .startDate(startDate)
                    .endDate(endDate)
                    .courseStatus(CourseEnum.NOT_STARTED)
                    .teacherName(teacherName)
                    .build();
        }
    }
}
