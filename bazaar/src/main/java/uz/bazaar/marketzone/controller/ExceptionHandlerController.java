package uz.bazaar.marketzone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.exceptions.AppBadException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseDto<String> handle(AppBadException e){
        e.printStackTrace();
        return ResponseDto.<String>builder()
                .success(false)
                .message(e.getMessage())
                .data(null)
                .code(-1)
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseDto<String> handle(RuntimeException e){
        e.printStackTrace();
        return ResponseDto.<String>builder()
                .success(false)
                .message(e.getMessage())
                .data(null)
                .code(-1)
                .build();
    }
}
