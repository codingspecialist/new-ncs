package shop.mtcoding.blog.course.exam;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog._core.utils.ApiUtil;
import shop.mtcoding.blog.user.User;

import java.io.IOException;
import java.util.List;

/**
 * 주소에 my가 붙어있으면 학생쪽, 없으면 관리자 or 강사 or 직원
 */
@RequiredArgsConstructor
@Controller
public class ExamController {
    private final HttpSession session;
    private final ExamService examService;

    @GetMapping("/api/exam")
    public String list(){
        return "course/exam/list";
    }

    @GetMapping("/api/exam/my/result")
    public String result(Model model){
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<ExamResponse.ResultDTO> respDTO = examService.시험결과리스트(sessionUser);
        model.addAttribute("models", respDTO);
        return "course/exam/my-result-list";
    }

    @GetMapping("/api/exam/{examId}/my/result")
    public String resultDetail(@PathVariable(value = "examId") Long examId, Model model){
        ExamResponse.ResultDetailDTO respDTO = examService.시험친결과상세보기(examId);
        model.addAttribute("model", respDTO);
        return "course/exam/my-result-detail";
    }

    @GetMapping("/api/exam/my/start")
    public String start(@RequestParam("paperId") Long paperId, Model model){
        User sessionUser = (User) session.getAttribute("sessionUser");
        ExamResponse.StartDTO respDTO = examService.시험치기(sessionUser, paperId);
        model.addAttribute("model", respDTO);
        return "course/exam/start";
    }

    @PostMapping("/api/exam/my")
    public ResponseEntity<?> save(@RequestBody ExamRequest.SaveDTO reqDTO) throws IOException {
        User sessionUser = (User) session.getAttribute("sessionUser");

        examService.시험결과저장(reqDTO, sessionUser);
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    @GetMapping("/api/exam/my")
    public String my(Model model){
        User sessionUser = (User) session.getAttribute("sessionUser");

        // TODO: 시험치는 날짜 subject에 evaluationDate 평가일 필요
        ExamResponse.MyPaperListDTO respDTO = examService.나의시험목록(sessionUser.getId());
        model.addAttribute("model", respDTO);
        return "course/exam/my-list";
    }


}
