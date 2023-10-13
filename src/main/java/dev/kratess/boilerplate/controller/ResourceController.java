package dev.kratess.boilerplate.controller;

import dev.kratess.boilerplate.dao.ResponseHandler;
import dev.kratess.boilerplate.dao.response.ResourceResponse;
import dev.kratess.boilerplate.model.Role;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    @PostMapping("")
    public ResponseEntity<Object> getResource() {
        return ResponseHandler.generateResponse(new ResourceResponse(Role.USER, "Resource accessible by user"));
    }

    @RolesAllowed("USER")
    @PostMapping("/user")
    public ResponseEntity<Object> getUserResource() {
        return ResponseHandler.generateResponse(new ResourceResponse(Role.USER, "Resource accessible by user"));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin")
    public ResponseEntity<Object> getAdminResource() {
        return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, new ResourceResponse(Role.ADMIN, "Resource " +
                "accessible by admin"));
    }
}
