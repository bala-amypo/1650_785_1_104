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
    public IssuedDeviceRecord(Long id,Long employeeId,Long deviceItemId,LocalDate issuedDate,LocalDate returnedDate){
        this.employeeId=employeeId;
        this.deviceItemId=deviceItemId;
        this.issuedDate=issuedDate;
        this.returnedDate=retuenedDate;
       
        this.createdAt=createdAt;
    }
}