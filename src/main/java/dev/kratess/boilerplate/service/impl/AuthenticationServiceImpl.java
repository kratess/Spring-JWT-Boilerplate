package dev.kratess.boilerplate.service.impl;

import dev.kratess.boilerplate.dao.request.SignInRequest;
import dev.kratess.boilerplate.dao.request.SignUpRequest;
import dev.kratess.boilerplate.util.exception.EmailAlreadyExistsException;
import dev.kratess.boilerplate.util.exception.UserNotExistsException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.kratess.boilerplate.dao.response.JwtAuthenticationResponse;
import dev.kratess.boilerplate.model.Role;
import dev.kratess.boilerplate.model.User;
import dev.kratess.boilerplate.repository.UserRepository;
import dev.kratess.boilerplate.service.AuthenticationService;
import dev.kratess.boilerplate.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) throws EmailAlreadyExistsException {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        User user = User.builder().firstName(request.firstName()).lastName(request.lastName())
                .email(request.email()).password(passwordEncoder.encode(request.password()))
                .role(Role.USER).build();
        userRepository.save(user);

        String jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) throws UserNotExistsException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(),
                request.password()));

        var user = userRepository.findByEmail(request.email()).orElseThrow();

        var jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponse(jwt);
    }
}