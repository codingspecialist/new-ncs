package shop.mtcoding.blog._core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import shop.mtcoding.blog._core.errors.exception.Exception401;
import shop.mtcoding.blog._core.utils.Script;
import shop.mtcoding.blog.user.User;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        String url = request.getRequestURI();
        System.out.println("주소 : "+url);

        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null){
            throw new Exception401("인증이 필요합니다");
        }else{
            String role = sessionUser.getRole();
            if(role.equals("student")){

                if(!sessionUser.getIsCheck()){
                    response.setContentType("text/html; charset-utf-8");
                    response.getWriter().println(Script.href("/student/check-form", "학생인증이 필요합니다"));
                    return false;
                }

                return true;
            }else{ // 선생님이면!!

                if(sessionUser.getSign() == null){
                    response.setContentType("text/html; charset-utf-8");
                    response.getWriter().println(Script.href("/teacher/sign-form", "사인이 필요합니다"));
                    return false;
                }
                return true;
            }
        }
    }
}
