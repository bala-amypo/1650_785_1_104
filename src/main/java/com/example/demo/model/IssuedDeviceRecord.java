package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private Long deviceItemId;

    // status as String (tests use "ISSUED"/"RETURNED")
    private String status;

    // REQUIRED BY TESTS
    private LocalDate returnedDate;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDeviceItemId() {
        return deviceItemId;
    }

    public void setDeviceItemId(Long deviceItemId) {
        this.deviceItemId = deviceItemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // METHODS NEEDED BY TESTS

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
