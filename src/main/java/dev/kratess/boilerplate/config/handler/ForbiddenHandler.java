package dev.kratess.boilerplate.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kratess.boilerplate.dao.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ForbiddenHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        ResponseEntity<Object> unauthorizedResponse = ResponseHandler.generateErrorResponse(HttpStatus.FORBIDDEN,
                "You must be authenticated in order to perform this action");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(unauthorizedResponse.getBody());
        response.setContentType("application/json");
        response.getWriter().write(responseJson);
    }
}