package dev.kratess.boilerplate.util.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotExistsException extends AuthenticationException {
    public UserNotExistsException(String msg) {
        super(msg);
    }
}
