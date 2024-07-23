package shop.mtcoding.blog.user;

import io.sentry.Sentry;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog._core.errors.exception.api.ApiException401;
import shop.mtcoding.blog._core.utils.ApiUtil;
import shop.mtcoding.blog._core.utils.Script;


@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/join-form")
    public String joinForm(){
        return "user/join-form";
    }

    @GetMapping("/login-form")
    public String loginForm(){
        return "user/login-form";
    }

    @PostMapping("/student/check")
    public @ResponseBody String studentCheck(UserRequest.StudentCheckDTO reqDTO){
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser==null) return "redirect:/login-form";

        userService.학생인증(reqDTO);

        session.invalidate();
        return Script.href("/login-form", "인증이 완료되었습니다. 로그인해주세요.");
    }

    @GetMapping("/student/check-form")
    public String studentCheckForm(){
        return "user/student-check-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO reqDTO) {
        User sessionUser = userService.회원가입(reqDTO);

        if(reqDTO.getRole().equals("student")){
            session.setAttribute("sessionUser", sessionUser);
            return "redirect:/student/check-form";
        }else{
            session.setAttribute("sessionUser", sessionUser);
            return "redirect:/teacher/sign-form";
        }
    }

    @PutMapping("/teacher/sign")
    public ResponseEntity<?> sign(@RequestBody UserRequest.TeacherSignDTO reqDTO){
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser.getRole().equals("student")) throw new ApiException401("당신은 선생님이 아니에요");
        userService.사인저장(reqDTO, sessionUser);
        session.invalidate();
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    @GetMapping("/teacher/sign-form")
    public String teacherSignForm(){
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser==null) return "redirect:/login-form";
        return "user/teacher-sign-form";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO) {
        User sessionUser = userService.로그인(reqDTO);
        session.setAttribute("sessionUser", sessionUser);

        if(sessionUser.getRole().equals("student")){
            if(sessionUser.getIsCheck()){
                return "redirect:/api/student/exam";
            }else{
                return "redirect:/student/check-form";
            }
        }else{
            return "redirect:/";
        }


    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
