package shop.mtcoding.blog._core.errors.exception.api;

import org.springframework.http.HttpStatus;
import shop.mtcoding.blog._core.utils.ApiUtil;

public class ApiException401 extends RuntimeException{

    public ApiException401(String msg) {
        super(msg);
    }

    public ApiUtil body(){
        return new ApiUtil(401, getMessage());
    }

    public HttpStatus status(){
        return HttpStatus.UNAUTHORIZED;
    }
}