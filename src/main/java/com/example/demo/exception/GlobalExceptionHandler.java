// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(BadRequestException.class)
//     public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//     }
// }
package com.example.demo.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(BadRequestException ex) {
        return build(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        return build(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        return build("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Map<String, Object>> build(String msg, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", status.value());
        map.put("message", msg);
        return new ResponseEntity<>(map, status);
    }
}
// package com.example.demo.exception;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleNotFound(
//             ResourceNotFoundException ex) {

//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public ResponseEntity<Map<String, String>> handleValidationErrors(
//             MethodArgumentNotValidException ex) {

//         Map<String, String> errors = new HashMap<>();

//         ex.getBindingResult().getFieldErrors()
//                 .forEach(error ->
//                         errors.put(error.getField(),
//                                    error.getDefaultMessage()));

//         return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//     }
// }
