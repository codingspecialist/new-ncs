package shop.mtcoding.blog.paper;

import lombok.Data;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.course.subject.element.SubjectElement;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.option.QuestionOption;

import java.util.List;

public class PaperRequest {

    @Data
    public static class QuestionSaveDTO {
        private Long elementId;
        private Long paperId;
        private Integer questionNo;
        private String questionTitle;
        private Integer questionPoint;
        private Integer questionAnswerNumber;
        List<OptionDTO> options;

        public Question toEntity(Paper paper, SubjectElement subjectElement){
            return Question.builder()
                    .no(questionNo)
                    .title(questionTitle)
                    .point(questionPoint)
                    .answerNumber(questionAnswerNumber)
                    .paper(paper)
                    .subjectElement(subjectElement)
                    .build();
        }

        @Data
        public static class OptionDTO {
            private Integer optionNo;
            private String optionContent;
            private Boolean optionRight;

            public QuestionOption toEntity(Question question){
                return QuestionOption.builder()
                        .no(optionNo)
                        .content(optionContent)
                        .isRight(optionRight)
                        .question(question)
                        .build();
            }
        }
    }

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
