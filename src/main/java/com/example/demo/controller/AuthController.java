// package com.example.demo.controller;

// import com.example.demo.model.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserAccountRepository userAccountRepository;

//     public AuthController(UserAccountRepository userAccountRepository) {
//         this.userAccountRepository = userAccountRepository;
//     }

//     @PostMapping("/register")
//     public UserAccount register(@RequestBody UserAccount user) {
//         user.setActive(true);  
//         return userAccountRepository.save(user);
//     }

//     @PostMapping("/login")
//     public UserAccount login(@RequestBody UserAccount request) {

//         for (UserAccount user : userAccountRepository.findAll()) {

//             if (user.getEmail().equals(request.getEmail())
//                     && user.getPasswordHash().equals(request.getPasswordHash())
//                     && Boolean.TRUE.equals(user.getActive())) {

//                 return user;
//             }
//         }

//         return null; 
//     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.UserAccount;
// import com.example.demo.service.UserAccountService;
// import com.example.demo.exception.BadRequestException;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserAccountService service;

//     public AuthController(UserAccountService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public UserAccount register(@RequestBody UserAccount user) {
//         return service.create(user);
//     }

//     @GetMapping("/users")
//     public List<UserAccount> getAllUsers() {
//         return service.getAll();
//     }

//     @GetMapping("/users/{id}")
//     public UserAccount getUser(@PathVariable Long id) {
//         return service.getById(id);
//     }

//     @PostMapping("/login")
//     public String login(@RequestBody UserAccount user) {
//         UserAccount dbUser = service.getAll()
//                 .stream()
//                 .filter(u -> u.getEmail().equals(user.getEmail())
//                         && u.getPasswordHash().equals(user.getPasswordHash()))
//                 .findFirst()
//                 .orElseThrow(() -> new BadRequestException("Invalid credentials"));

//         return "Login successful for " + dbUser.getEmail();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository repository;

    public AuthController(UserAccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        Optional<UserAccount> userOpt = repository.findByUsername(username);

        if (userOpt.isEmpty()) {
            return "Invalid username";
        }

        UserAccount user = userOpt.get();

        if (!user.getPassword().equals(password)) {
            return "Invalid password";
        }

        return "Login successful";
    }
}
