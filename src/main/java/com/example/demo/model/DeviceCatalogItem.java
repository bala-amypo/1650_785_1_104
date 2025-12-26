// com/example/demo/model/DeviceCatalogItem.java
package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "device_catalog_items")
public class DeviceCatalogItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String deviceCode;
    
    private String deviceType;
    private String model;
    
    @Min(value = 1, message = "maxAllowedPerEmployee must be greater than 0")
    private int maxAllowedPerEmployee;
    
    private boolean active = true;
    
    // Constructors
    public DeviceCatalogItem() {}
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDeviceCode() { return deviceCode; }
    public void setDeviceCode(String deviceCode) { this.deviceCode = deviceCode; }
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getMaxAllowedPerEmployee() { return maxAllowedPerEmployee; }
    public void setMaxAllowedPerEmployee(int maxAllowedPerEmployee) { 
        this.maxAllowedPerEmployee = maxAllowedPerEmployee; 
    }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
