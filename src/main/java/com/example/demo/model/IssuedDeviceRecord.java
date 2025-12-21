package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private boolean returned;   // 🔴 MISSING FIELD

    public IssuedDeviceRecord() {
    }

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

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {   // 🔴 MISSING SETTER
        this.returned = returned;
    }
}
