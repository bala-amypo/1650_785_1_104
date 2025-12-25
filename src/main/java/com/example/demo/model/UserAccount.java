
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

import javax.persistence.*;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String role;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}