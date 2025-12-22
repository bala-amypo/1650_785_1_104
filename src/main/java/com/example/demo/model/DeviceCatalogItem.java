package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "device_catalog")
public class DeviceCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deviceName;

    @Column(nullable = false)
    private String deviceType;

    @Column(nullable = false)
    private int maxAllowedDevices;

    public DeviceCatalog() {
    }

    public DeviceCatalog(String deviceName, String deviceType, int maxAllowedDevices) {
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.maxAllowedDevices = maxAllowedDevices;
    }

    public Long getId() {
        return id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getMaxAllowedDevices() {
        return maxAllowedDevices;
    }

    public void setMaxAllowedDevices(int maxAllowedDevices) {
        this.maxAllowedDevices = maxAllowedDevices;
    }
}
