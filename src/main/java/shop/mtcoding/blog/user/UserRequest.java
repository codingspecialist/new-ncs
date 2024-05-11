package shop.mtcoding.blog.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class TeacherSignDTO {
        private String sign;
    }

    @Data
    public static class StudentCheckDTO {
        private Long userId;
        private String name;
        private String birthday;
    }

    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
        private String name;
        private String role;

        public User toEntity(){
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .name(name)
                    .role(role)
                    .isCheck(false) // 인증안됨
                    .isTeacher(role.equals("teacher") ? true : false)
                    .build();
        }
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }
}
