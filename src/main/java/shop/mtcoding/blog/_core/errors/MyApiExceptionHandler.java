package shop.mtcoding.blog._core.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.blog._core.errors.exception.*;
import shop.mtcoding.blog._core.errors.exception.api.*;
import shop.mtcoding.blog._core.utils.ApiUtil;
import shop.mtcoding.blog._core.utils.Script;

@Slf4j
@RestControllerAdvice
public class MyApiExceptionHandler {

    @ExceptionHandler(ApiException400.class)
    public ResponseEntity<?> badRequest(ApiException400 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(ApiException401.class)
    public ResponseEntity<?> unAuthorized(ApiException401 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(ApiException403.class)
    public ResponseEntity<?> forbidden(ApiException403 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(ApiException404.class)
    public ResponseEntity<?> notFound(ApiException404 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(ApiException500.class)
    public ResponseEntity<?> serverError(ApiException500 e){
        log.error(e.getMessage());
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unknown(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(new ApiUtil<>(500, "알수없는오류"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
