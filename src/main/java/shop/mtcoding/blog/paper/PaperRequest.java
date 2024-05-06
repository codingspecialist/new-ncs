package shop.mtcoding.blog.paper;

import lombok.Data;
import shop.mtcoding.blog.course.subject.Subject;

public class PaperRequest {

    @Data
    public static class SaveDTO {
        private Long subjectId;
        private Integer count;
        private String paperState;

        public Paper toEntity(Subject subject){
            return Paper.builder()
                    .subject(subject)
                    .count(count)
                    .paperState(paperState)
                    .build();
        }
    }
}
