package shop.mtcoding.blog.course;

import lombok.Data;
import org.springframework.data.domain.Page;
import shop.mtcoding.blog.course.subject.Subject;

import java.time.LocalDate;
import java.util.List;

public class CourseResponse {

    @Data
    public static class SelectedDTO {
        private Long currentCourseId;
        private List<CourseDTO> courses;

        public SelectedDTO(Long currentCourseId, List<Course> courses) {
            this.currentCourseId = currentCourseId;
            this.courses = courses.stream().map(course -> new CourseDTO(course, currentCourseId)).toList();
        }

        @Data
        public static class CourseDTO {
            private Long courseId;
            private String title;
            private Integer round;
            private Boolean isSelected;

            public CourseDTO(Course course, Long currentCourseId) {
                this.courseId = course.getId();
                this.title = course.getTitle();
                this.round = course.getRound();
                this.isSelected = course.getId().equals(currentCourseId) ? true : false;
            }
        }
    }

    @Data
    public static class PagingDTO {
        private Integer totalPage; // 전체 페이지 수
        private Integer pageSize; // 페이지 별 아이템 개수
        private Integer pageNumber; // 현재 페이지 번호
        private Boolean isFirst; // 첫번째 페이지 여부
        private Boolean isLast; // 마지막 페이지 여부
        private List<DTO> courses;

        public PagingDTO(Page<Course> paging) {
            this.totalPage = paging.getTotalPages();
            this.pageSize = paging.getSize();
            this.pageNumber = paging.getNumber();
            this.isFirst = paging.isFirst();
            this.isLast = paging.isLast();
            this.courses = paging.getContent().stream().map(DTO::new).toList();
        }

        @Data
        class DTO {
            private Long id;
            private String title;
            private String code;
            private Integer totalTime;
            private Integer totalDay;
            private Integer round;
            private Integer level;
            private String purpose;
            private LocalDate startDate;
            private LocalDate endDate;
            private String teacherName;
            private String courseStatus;

            public DTO(Course course) {
                this.id = course.getId();
                this.title = course.getTitle();
                this.code = course.getCode();
                this.totalTime = course.getTotalTime();
                this.totalDay = course.getTotalDay();
                this.round = course.getRound();
                this.level = course.getLevel();
                this.purpose = course.getPurpose();
                this.startDate = course.getStartDate();
                this.endDate = course.getEndDate();
                this.teacherName = course.getTeacherName();
                this.courseStatus = course.getCourseStatus().value;
            }
        }
    }

    @Data
    public static class DetailDTO {
        private Long courseId;
        private String courseCode;
        private String courseTitle;
        private Integer courseRound;
        private String courseStatus;

        private List<SubjectDTO> subjects;

        public DetailDTO(Course course, List<Subject> subjects) {
            this.courseId = course.getId();
            this.courseCode = course.getCode();
            this.courseTitle = course.getTitle();
            this.courseRound = course.getRound();
            this.courseStatus = course.getCourseStatus().value;
            this.subjects = subjects.stream().map(SubjectDTO::new).toList();
        }

        @Data
        class SubjectDTO {
            private Long subjectId;
            private String code; // 능력단위 코드
            private String title;
            private String purpose;
            private String gubun;
            private Integer grade;
            private Integer totalTime;
            private Integer no; // 과정에서 몇번째로 시작하는 교과목인지에 대한 연번
            private String learningWay; // 학습 방법
            private String evaluationWay; // 평가 방법
            private LocalDate evaluationDate; // 평가일
            private LocalDate revaluationDate; // 재평가일
            private LocalDate evaluationScheduleDate; // 평가 예정일
            private LocalDate revaluationScheduleDate; // 재평가 예정일
            private LocalDate startDate; // 교과목 시작 날짜
            private LocalDate endDate; // 교과목 종료 날짜
            private Long courseId; // 과정 PK

            public SubjectDTO(Subject subject) {
                this.subjectId = subject.getId();
                this.code = subject.getCode();
                this.title = subject.getTitle();
                this.purpose = subject.getPurpose();
                this.gubun = subject.getGubun();
                this.grade = subject.getGrade();
                this.totalTime = subject.getTotalTime();
                this.no = subject.getNo();
                this.learningWay = subject.getLearningWay();
                this.evaluationWay = subject.getEvaluationWay();
                this.evaluationDate = subject.getEvaluationDate();
                this.revaluationDate = subject.getRevaluationDate();
                this.startDate = subject.getStartDate();
                this.endDate = subject.getEndDate();
                this.courseId = subject.getCourse().getId();
            }
        }
    }
}
