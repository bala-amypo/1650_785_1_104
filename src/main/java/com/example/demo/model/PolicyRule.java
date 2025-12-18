package com.example.demo.model;
import jakarta.persistence.*;
// import java.time.LocalDateTime;
@Entity
public class PolicyRule{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String ruleCode;
    private String description;
    private String appliesToRole;
    private String appliesToDepartment;
    private Integer maxDevicesAllowed;
    private Boolean active;
    public PolicyRule(){

    }
    public PolicyRule(private Long id,
    @Column(unique=true) private String ruleCode,
     String description,
     String appliesToRole,
     String appliesToDepartment,
     Integer maxDevicesAllowed,
     Boolean active){
        this.ruleCode=ruleCode;
        this.description=description;
        this.applieToRole=appliesToRole;
        this.appliesToDepartment=appliesToDepartment;
        this.maxDevicesAllowed=maxDevicesAllowed;
     }
     public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getRuleCode(){
        return ruleCode;
    }
    public void setRuleCode(String ruleCode){
        this.ruleCode=ruleCode;
    }
    public String getdescription(){
        return description;
    }
    public void setfullname(String fullName){
        this.fullName=fullName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String getJobRole(){
        return jobRole;
    }
    public void setJobRole(String jobRole){
        this.jobRole=jobRole;
    }

}