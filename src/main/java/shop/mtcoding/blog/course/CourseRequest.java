package shop.mtcoding.blog.course;

import lombok.Data;

import java.time.LocalDate;

public class CourseRequest {

    @Data
    public static class SaveDTO {
        private String code;
        private String title;
        private Integer level;
        private String purpose;
        private Integer totalTime;
        private Integer totalDay;
        private Integer round;
        private LocalDate startDate;
        private LocalDate endDate;
        private String mainTeacherName;

        public Course toEntity(){
            return Course.builder()
                    .code(code)
                    .title(title)
                    .level(level)
                    .purpose(purpose)
                    .totalTime(totalTime)
                    .totalDay(totalDay)
                    .round(round)
                    .startDate(startDate)
                    .endDate(endDate)
                    .courseStatus(CourseEnum.NOT_STARTED)
                    .mainTeacherName(mainTeacherName)
                    .build();
        }
    }
}
