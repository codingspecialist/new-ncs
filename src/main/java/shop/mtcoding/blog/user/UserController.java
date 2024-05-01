package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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

    @PostMapping("/student-check")
    public String studentCheck(UserRequest.StudentCheckDTO reqDTO){
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser==null) return "redirect:/login-form";

        User userPS =userService.학생인증(reqDTO);

        session.setAttribute("sessionUser", userPS);
        return "redirect:/api/exam/my";
    }

    @GetMapping("/student-check-form")
    public String studentCheckForm(){
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser==null) return "redirect:/login-form";
        return "user/student-check-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO reqDTO) {
        User sessionUser = userService.회원가입(reqDTO);

        if(reqDTO.getRole().equals("student")){
            session.setAttribute("sessionUser", sessionUser);
            return "redirect:/student-check-form";
        }

        return "redirect:/login-form";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO) {
        User sessionUser = userService.로그인(reqDTO);
        session.setAttribute("sessionUser", sessionUser);

        if(sessionUser.getRole().equals("student")){
            if(sessionUser.getStatus()){
                session.setAttribute("teacher", sessionUser.getRole().equals("teacher"));
                return "redirect:/api/exam";
            }else{
                return "redirect:/student-check-form";
            }
        }else{
            session.setAttribute("teacher", sessionUser.getRole().equals("teacher"));
            return "redirect:/";
        }


    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
