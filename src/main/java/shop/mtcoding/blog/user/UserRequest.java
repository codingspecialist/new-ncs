package shop.mtcoding.blog.user;

import lombok.Data;

public class UserRequest {

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
                    .status(false) // 인증안됨
                    .build();
        }
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }
}
