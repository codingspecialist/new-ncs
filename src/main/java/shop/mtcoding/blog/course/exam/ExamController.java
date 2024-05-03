package shop.mtcoding.blog.course.exam;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog.user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ExamController {
    private final HttpSession session;
    private final ExamService examService;

    @PostMapping("/api/exam/my")
    public @ResponseBody String exam(@RequestBody ExamRequest.SaveDTO reqDTO) throws IOException {
        User sessionUser = (User) session.getAttribute("sessionUser");

        examService.시험결과저장(reqDTO, sessionUser);
        return "";
    }

    @GetMapping("/api/exam")
    public String list(){
        return "course/exam/list";
    }

    @GetMapping("/api/exam/my")
    public String my(Model model){
        User sessionUser = (User) session.getAttribute("sessionUser");

        ExamResponse.MyPaperListDTO respDTO = examService.나의시험목록(sessionUser.getId());
        model.addAttribute("model", respDTO);
        return "course/exam/my-list";
    }

    @GetMapping("/api/exam/my/start")
    public String start(@RequestParam("paperId") Long paperId, Model model){
        User sessionUser = (User) session.getAttribute("sessionUser");
        ExamResponse.ExamStartDTO respDTO = examService.나의시험(sessionUser, paperId);
        model.addAttribute("model", respDTO);
        return "course/exam/start";
    }
}
