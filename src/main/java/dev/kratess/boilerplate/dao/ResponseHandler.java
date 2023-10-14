package dev.kratess.boilerplate.dao;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(@NotNull HttpStatus status, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generateResponse(Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("status", HttpStatus.OK.value());

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    public static ResponseEntity<Object> generateErrorResponse(@NotNull HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", status.getReasonPhrase());
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generateErrorResponse(@NotNull HttpStatus status, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", status.getReasonPhrase());
        map.put("message", message);
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generateErrorResponse(@NotNull HttpStatus status, Map<String, String> fields) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", status.getReasonPhrase());
        map.put("fields", fields);
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

}