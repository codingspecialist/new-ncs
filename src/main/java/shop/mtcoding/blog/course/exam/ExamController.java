package shop.mtcoding.blog.course.exam;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.blog.user.User;

import java.util.List;

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
    public String my(Model model){
        User sessionUser = (User) session.getAttribute("sessionUser");

        List<ExamResponse.MyPaperDTO> respDTOs = examService.나의시험지목록(sessionUser.getId());
        model.addAttribute("models", respDTOs);
        return "course/exam/my-list";
    }
}
