package com.example.demo.model;

@Entity
public class EmployeeProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String employeeId
    private String fullName;
    @Column(unique=true)
    private 
}