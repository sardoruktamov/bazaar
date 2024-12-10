package uz.bazaar.marketzone.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.exceptions.AppBadException;

import java.util.*;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        List<String> errors = new LinkedList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }

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
