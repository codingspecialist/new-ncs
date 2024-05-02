package shop.mtcoding.blog.course.exam;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.blog.user.User;

@RequiredArgsConstructor
@Controller
public class ExamController {
    private final HttpSession session;
    private final ExamService examService;

    @GetMapping("/api/exam")
    public String list(){
        return "course/exam/list";
    }

    @GetMapping("/api/exam/my")
    public String my(){
        User sessionUser = (User) session.getAttribute("sessionUser");

        examService.시험지목록(sessionUser.getId());

        return "course/exam/my";
    }
}
