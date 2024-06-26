package shop.mtcoding.blog._core.errors.exception.api;

import org.springframework.http.HttpStatus;
import shop.mtcoding.blog._core.utils.ApiUtil;

public class ApiException403 extends RuntimeException{

    public ApiException403(String msg) {
        super(msg);
    }

    public ApiUtil body(){
        return new ApiUtil(403, getMessage());
    }

    public HttpStatus status(){
        return HttpStatus.FORBIDDEN;
    }
}