package dev.kratess.boilerplate.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kratess.boilerplate.dao.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UnauthorizedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException arg2) throws IOException {
        ResponseEntity<Object> unauthorizedResponse = ResponseHandler.generateErrorResponse(HttpStatus.NOT_ACCEPTABLE,
                "You don't have the required role to perform this action");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(unauthorizedResponse.getBody());
        response.setContentType("application/json");
        response.getWriter().write(responseJson);
    }
}