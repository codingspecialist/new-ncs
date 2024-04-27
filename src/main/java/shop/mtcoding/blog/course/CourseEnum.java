package shop.mtcoding.blog.course;

public enum CourseEnum {
    NOT_STARTED("과정진행전"), RUNNING("과정진행중"), FINISHED("과정종료");

    String value;

    CourseEnum(String value) {
        this.value = value;
    }
}
