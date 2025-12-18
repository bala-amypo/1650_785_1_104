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
    
}