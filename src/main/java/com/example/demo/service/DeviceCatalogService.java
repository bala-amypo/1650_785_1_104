package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;

import java.util.List;

public interface DeviceCatalogItemService {

    DeviceCatalogItem createDevice(DeviceCatalogItem item);

    List<DeviceCatalogItem> getAllDevices();

    DeviceCatalogItem getDeviceById(Long id);

    void deleteDevice(Long id);
}
