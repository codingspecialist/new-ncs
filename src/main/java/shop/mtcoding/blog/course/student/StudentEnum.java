package shop.mtcoding.blog.course.student;

import lombok.Getter;

@Getter
public enum StudentEnum {
    EMPLOYED("취업"),       // 취업
    DROPOUT("중도탈락"),        // 중도탈락
    INCOMPLETE("미이수"),     // 미이수
    COMPLETED("이수"),      // 이수
    ENROLLED("재학중");        // 재학중

    private String value;

    StudentEnum(String value) {
        this.value = value;
    }
}
