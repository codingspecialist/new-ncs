package shop.mtcoding.blog.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class DTO {
        private int id;
        private String username;
        private String email;
        private String name;

        public DTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.name = user.getName();
        }
    }
}
