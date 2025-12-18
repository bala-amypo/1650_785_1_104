package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class IssuedDeviceRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    // @Column(unique=true)
    private Long employeeId;
    private Long deviceItemId;
    private LocalDate issuedDate;
    private LocalDate returnedDate;
    private String status;
    public IssuedDeviceRecord(){

    }
    public IssuedDeviceRecord(Long id,Long employeeId,Long deviceItemId,LocalDate issuedDate,LocalDate returnedDate,String status){
        this.employeeId=employeeId;
        this.deviceItemId=deviceItemId;
        this.issuedDate=issuedDate;
        this.returnedDate=returnedDate;
        this.status=status;
    }
    ublic Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(Long employeeId){
        this.employeeId=employeeId;
    }
    public Long deviceItemId(){
        return deviceItemId;
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