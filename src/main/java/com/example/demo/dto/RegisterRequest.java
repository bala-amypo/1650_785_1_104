package com.example.demo.dto;

public class RegisterRequest {

    private String message;

    public RegisterResponse() {}

    public RegisterResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}