// com.example.demo.model.IssuedDeviceRecord
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long deviceItemId;

    // change type to String
    private String status;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Long getDeviceItemId() { return deviceItemId; }
    public void setDeviceItemId(Long deviceItemId) { this.deviceItemId = deviceItemId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // returnedDate etc. as you already have
}
