package shop.mtcoding.blog._core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import shop.mtcoding.blog._core.errors.exception.Exception401;
import shop.mtcoding.blog.user.User;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        String url = request.getRequestURI();
        System.out.println("주소 : "+url);

        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null){
            throw new Exception401("인증되지 않았습니다");
        }else{
            String role = sessionUser.getRole();
            if(role.equals("student")){
                if(url.startsWith("/api/exam")){
                    return true;
                }else{
                    throw new Exception401("해당 리소스에 접근할 권한이 없습니다");
                }
            }
        }
        return true;
    }
}
