package shop.mtcoding.blog.course.student;

import lombok.Data;
import shop.mtcoding.blog.course.Course;

public class StudentRequest {

    @Data
    public static class SaveDTO {
        private String name;
        private String birthday;

        public Student toEntity(Course course){
            return Student.builder()
                    .name(name)
                    .birthday(birthday)
                    .state(StudentEnum.ENROLLED)
                    .course(course)
                    .build();
        }
    }
}
