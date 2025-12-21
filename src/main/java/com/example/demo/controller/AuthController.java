package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService service;

    public AuthController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        user.setActive(true);
        return service.create(user);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount request) {
        return service.login(
                request.getEmail(),
                request.getPasswordHash()
        );
    }
}