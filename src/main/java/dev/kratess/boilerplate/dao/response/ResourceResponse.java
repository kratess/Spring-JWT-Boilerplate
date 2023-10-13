package dev.kratess.boilerplate.dao.response;

import dev.kratess.boilerplate.model.Role;

public record ResourceResponse(
        Role role,
        String message
) {
}