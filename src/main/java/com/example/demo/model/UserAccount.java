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
    private Boolean active=true;
    private LocalDateTime createdAt;
    public EmployeeProfile(){

    }
    public EmployeeProfile(Long id,@Column(unique=true) String employeeId,String fullName,@Column(unique=true) String email,String jobRole,Boolean active,LocalDateTime createdAt){
        this.employeeId=employeeId;
        this.full
    }
}