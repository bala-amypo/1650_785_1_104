package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class EligibilityCheckRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    // @Column(unique=true)
    private Long employeeId;
    private Long deviceItemId;
    private Boolean isEligible;
    private LocalDateTime checkedAt;
    
}