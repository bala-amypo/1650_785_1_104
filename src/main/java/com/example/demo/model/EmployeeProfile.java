// package com.example.demo.model;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;
// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// public class EmployeeProfile {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String employeeId;
//     private String name;
//     private String department;
//     private boolean active;
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeId;

    @Column(unique = true)
    private String email;

    private String fullName;
    private String department;
    private String jobRole;
    private Boolean active;
    private LocalDateTime createdAt;
}