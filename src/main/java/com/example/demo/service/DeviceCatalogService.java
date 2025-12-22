package com.example.demo.service;

import com.example.demo.entity.DeviceCatalog;

import java.util.List;

public interface DeviceCatalogService {

    DeviceCatalog createDevice(DeviceCatalog deviceCatalog);

    List<DeviceCatalog> getAllDevices();

    DeviceCatalog getDeviceById(Long id);

    void deleteDevice(Long id);
}
