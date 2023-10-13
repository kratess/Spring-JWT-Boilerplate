package dev.kratess.boilerplate.config.handler;

import dev.kratess.boilerplate.dao.ResponseHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebMvc
@RestControllerAdvice
public class NotFoundHandler {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNotFound() {
        return ResponseHandler.generateErrorResponse(HttpStatus.NOT_FOUND, "Error 404");
    }
}