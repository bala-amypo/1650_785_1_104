package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Issued{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String employeeId;