package dev.kratess.boilerplate.service;

import dev.kratess.boilerplate.dao.request.SignInRequest;
import dev.kratess.boilerplate.dao.request.SignUpRequest;
import dev.kratess.boilerplate.dao.response.JwtAuthenticationResponse;
import dev.kratess.boilerplate.util.exception.EmailAlreadyExistsException;
import dev.kratess.boilerplate.util.exception.UserNotExistsException;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request) throws EmailAlreadyExistsException;
    JwtAuthenticationResponse signin(SignInRequest request) throws UserNotExistsException;
}