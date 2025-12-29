package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository userRepo;
    private final JwtTokenProvider jwtTokenProvider;

    // 🔐 simple setup (no Spring injection yet)
    private static final String SECRET_KEY =
            "MyJwtSecretKeyThatIsAtLeast32CharactersLong";
    private static final long VALIDITY_MS = 3600000; // 1 hour

    public AuthController(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
        this.jwtTokenProvider = new JwtTokenProvider(SECRET_KEY, VALIDITY_MS);
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserAccount request) {

        UserAccount user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtTokenProvider.generateToken(user);
        return ResponseEntity.ok(token);
    }
}
