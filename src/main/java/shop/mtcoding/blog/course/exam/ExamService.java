package shop.mtcoding.blog.course.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.course.student.StudentRepository;
import shop.mtcoding.blog.paper.PaperRepository;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final PaperRepository paperRepository;
    private final StudentRepository studentRepository;

    public void 시험지목록(Long sessionUserId){

    }
}
