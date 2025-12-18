package com.example.demo.model;

@Entity
public class EmployeeProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String employeeId;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String department;
    private String jobRole;
    private Boolean active;
    private LocalDateTime createdAt;
    public EmployeeProfile(){

    }
    public EmployeeProfile(Long id,String employeeId,String fullName,String email,String jobRole,Boolean active,LocalDateTime createdAt)
}