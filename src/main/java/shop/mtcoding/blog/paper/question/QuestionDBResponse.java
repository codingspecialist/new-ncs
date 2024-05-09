package shop.mtcoding.blog.paper.question;

import lombok.Data;

public class QuestionDBResponse {

    @Data
    public static class ExpectedNextDTO{
        private Integer expectNo;
        private Integer expectPoint;

        public ExpectedNextDTO(Integer expectNo, Integer expectPoint) {
            this.expectNo = expectNo;
            this.expectPoint = expectPoint;
        }
    }

}
