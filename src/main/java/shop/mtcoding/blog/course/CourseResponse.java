package shop.mtcoding.blog.course;

import lombok.Data;
import org.springframework.data.domain.Page;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.course.subject.Subject;

import java.time.LocalDate;
import java.util.List;

public class CourseResponse {

    @Data
    public static class SelectedDTO {
        private Long currentCourseId;
        private List<CourseDTO> courses;

        public SelectedDTO(Long currentCourseId, List<Course> courses) {
            this.currentCourseId = currentCourseId == null ? 0 : currentCourseId;
            this.courses = courses.stream().map(course -> new CourseDTO(course, this.currentCourseId)).toList();
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
                this.teacherName = course.getMainTeacherName();
                this.courseStatus = course.getCourseStatus().getValue();
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
        private List<StudentDTO> students;

        public DetailDTO(Course course, List<Subject> subjects, List<Student> students) {
            this.courseId = course.getId();
            this.courseCode = course.getCode();
            this.courseTitle = course.getTitle();
            this.courseRound = course.getRound();
            this.courseStatus = course.getCourseStatus().getValue();
            this.subjects = subjects.stream().map(SubjectDTO::new).toList();
            this.students = students.stream().map(StudentDTO::new).toList();
        }

        @Data
        class StudentDTO {
            private Long studentId;
            private String name; // 학생 번호는 이름순으로 해서 rownum 뽑자
            private String birthday;
            private String state; // 취업, 중도탈락, 미이수, 이수, 재학중
            private String dropOutDate; // 중탈 날짜
            private String dropOutReason; // 중탈 이유
            private String comment; // 학생 모든 교과목에 대한 총평
            private String grade; // 학생 모든 교과목에 대한 수준 1,2,3,4,5
            private Long courseId;

            public StudentDTO(Student student) {
                this.studentId = student.getId();
                this.name = student.getName();
                this.birthday = student.getBirthday();
                this.state = student.getState().getValue();
                this.dropOutDate = student.getDropOutDate() == null ? "" : student.getDropOutDate().toString();
                this.dropOutReason = student.getDropOutReason() == null ? "" : student.getDropOutReason();
                this.comment = student.getComment()  == null ? "" : student.getComment();
                this.grade = student.getGrade()  == null ? "" : student.getGrade().toString();
                this.courseId = student.getCourse().getId();
            }
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
