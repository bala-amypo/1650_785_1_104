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
        this.fullName=fullName;
        this.email=email;
        this.department=department;
        this.jobRole=jobRole;
        this.active=true;
        this.createdAt=createdAt;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(String employeeId){
        this.employeeId=employeeId;
    }
    public String getfullName(){
        return fullname;
    }
    public void setfullname(String fullName){
        this.fullName=fullName;
    }
    public String getEmail(){
        return email;
    }
    public void setE
}