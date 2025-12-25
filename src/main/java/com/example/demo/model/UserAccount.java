
// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Table(name = "user_accounts")
// @Getter
// @Setter
// public class UserAccount {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // 🔴 THIS FIELD WAS MISSING BEFORE
//     @Column(unique = true, nullable = false)
//     private String username;

//     @Column(nullable = false)
//     private String passwordHash;

//     private boolean active;
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String role;
    private String password;
}
