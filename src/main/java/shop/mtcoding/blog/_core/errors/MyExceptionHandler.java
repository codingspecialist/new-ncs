package shop.mtcoding.blog._core.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog._core.errors.exception.*;
import shop.mtcoding.blog._core.utils.Script;

// RuntimeException이 터지면 해당 파일로 오류가 모인다
@ControllerAdvice // 데이터 응답
public class MyExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(StudentCheckException.class)
    public @ResponseBody String ex401(StudentCheckException e){
        return Script.href("/student-check-form", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception400.class)
    public @ResponseBody String ex400(Exception400 e){
        return Script.back(e.getMessage()); // http body, http header
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(Exception401.class)
    public @ResponseBody String ex401(Exception401 e){
        return Script.href("/login-form");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(Exception403.class)
    public @ResponseBody String ex403(Exception403 e){
        return Script.back(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception404.class)
    public @ResponseBody String ex404(Exception404 e){
        System.out.println("여기 걸리지가 않나?");
        return Script.back(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception500.class)
    public @ResponseBody String ex500(Exception500 e){
        return Script.back(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody String unknown(Exception e){
        return Script.unknownBack(e.getMessage());
    }
}
