package shop.mtcoding.blog.course.subject.element;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * 1. 교과목에 대한 세부 내용이다.
 * 2. 교과목이 자바라면 SubjectElement 는 반복문, 조건문, 오버로딩
 */

@NoArgsConstructor
@Getter
@Entity
public class SubjectElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createDate;
}
