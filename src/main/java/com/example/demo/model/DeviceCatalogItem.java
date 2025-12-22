package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "device_catalog")
public class DeviceCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;
    private String deviceType;
    private int maxAllowedDevices;

    public DeviceCatalogItem() {
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
