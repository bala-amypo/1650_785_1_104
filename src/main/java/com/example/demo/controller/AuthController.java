
// // package com.example.demo.controller;

// // import com.example.demo.model.UserAccount;
// // import com.example.demo.repository.UserAccountRepository;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.Optional;

// // @RestController
// // @RequestMapping("/auth")
// // public class AuthController {

// //     private final UserAccountRepository repository;

// //     public AuthController(UserAccountRepository repository) {
// //         this.repository = repository;
// //     }

// //     @PostMapping("/register")
// //     public UserAccount register(@RequestBody UserAccount user) {
// //         return repository.save(user);
// //     }

// //     @GetMapping("/login/{username}")
// //     public Optional<UserAccount> login(@PathVariable String username) {
// //         return repository.findByUsername(username);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.UserAccount;
// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final JwtTokenProvider jwtTokenProvider;

//     public AuthController(JwtTokenProvider jwtTokenProvider) {
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody AuthRequest request) {

//         UserAccount user = new UserAccount(
//                 1L,
//                 request.getEmail(),
//                 "ADMIN",
//                 request.getPassword()
//         );

//         String token = jwtTokenProvider.generateToken(user);
//         return new AuthResponse(token);
//     }

//     @PostMapping("/register")
//     public RegisterRequest register() {
//         return new RegisterRequest("User registered successfully");
//     }
// }
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository userRepo;

    public AuthController(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount use) {
        return "";
       
    }
}
