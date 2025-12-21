package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository userAccountRepository;

    public AuthController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // POST /auth/register
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        user.setActive(true);   // ensure active
        return userAccountRepository.save(user);
    }

    // POST /auth/login
    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount request) {

        for (UserAccount user : userAccountRepository.findAll()) {

            if (user.getEmail().equals(request.getEmail())
                    && user.getPasswordHash().equals(request.getPasswordHash())
                    && Boolean.TRUE.equals(user.getActive())) {

                return user;
            }
        }

        return null; // test-friendly
    }
}