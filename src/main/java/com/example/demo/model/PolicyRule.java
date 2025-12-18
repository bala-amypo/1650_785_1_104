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
        this.appliesToDepartmen
     }
}