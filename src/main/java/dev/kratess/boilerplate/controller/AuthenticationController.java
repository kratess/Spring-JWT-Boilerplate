package dev.kratess.boilerplate.controller;

import dev.kratess.boilerplate.dao.ResponseHandler;
import dev.kratess.boilerplate.dao.request.SignInRequest;
import dev.kratess.boilerplate.dao.request.SignUpRequest;
import dev.kratess.boilerplate.service.AuthenticationService;
import dev.kratess.boilerplate.util.exception.EmailAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody SignUpRequest request) {
        try {
            return ResponseHandler.generateResponse(authenticationService.signup(request));
        } catch (EmailAlreadyExistsException ex) {
            return ResponseHandler.generateErrorResponse(HttpStatus.CONFLICT, "Email already in use");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@Valid @RequestBody SignInRequest request) {
        try {
            return ResponseHandler.generateResponse(authenticationService.signin(request));
        } catch (AuthenticationException ex) {
            return ResponseHandler.generateErrorResponse(HttpStatus.UNAUTHORIZED, "Email or password invalid");
        }
    }

}