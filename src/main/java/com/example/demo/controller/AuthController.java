package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository userAccountRepository;

    public AuthController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return userAccountRepository.save(user);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }
}