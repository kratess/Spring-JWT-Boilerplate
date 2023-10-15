package dev.kratess.boilerplate.config.handler;

import dev.kratess.boilerplate.dao.ResponseHandler;
import jakarta.servlet.ServletException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ServletExceptionHandler {
    @ExceptionHandler(ServletException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(ServletException ex) {
        return ResponseHandler.generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}