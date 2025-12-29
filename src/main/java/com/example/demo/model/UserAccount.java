// // com/example/demo/model/UserAccount.java
// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity  
// @Table(name = "user_accounts")
// public class UserAccount {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     private String email;
//     private String role;
    

//     public UserAccount() {}
    
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String role;

    private String password;

    public UserAccount() {
    }

    public UserAccount(Long id, String email, String role, String password) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    // ✅ GETTERS (this fixes your error)
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    // setters (needed for request body)
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
