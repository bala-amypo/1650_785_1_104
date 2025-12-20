package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Long deviceItemId;
    private Boolean returned = false;

    public IssuedDeviceRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Long getDeviceItemId() { return deviceItemId; }
    public void setDeviceItemId(Long deviceItemId) { this.deviceItemId = deviceItemId; }

    public Boolean getReturned() { return returned; }
    public void setReturned(Boolean returned) { this.returned = returned; }
}