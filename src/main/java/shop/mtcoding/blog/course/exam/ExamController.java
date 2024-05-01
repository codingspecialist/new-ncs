package shop.mtcoding.blog.course.exam;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ExamController {
    private final HttpSession session;

    @GetMapping("/api/exam")
    public String list(){
        return "course/exam/list";
    }

    @GetMapping("/api/exam/my")
    public String my(){
        return "course/exam/my";
    }
}
