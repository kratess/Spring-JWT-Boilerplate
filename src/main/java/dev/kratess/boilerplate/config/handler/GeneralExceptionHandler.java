package dev.kratess.boilerplate.config.handler;

import dev.kratess.boilerplate.dao.ResponseHandler;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> createResponseEntity(Object body, HttpHeaders headers, HttpStatusCode statusCode,
                                                          WebRequest request) {
        HttpStatus httpStatus = HttpStatus.resolve(statusCode.value());

        if (httpStatus == null) return ResponseHandler.generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseHandler.generateErrorResponse(httpStatus, ((ProblemDetail) body).getDetail());
    }
}