package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceCatalogController {

    private final DeviceCatalogService deviceCatalogService;

    public DeviceCatalogController(DeviceCatalogService deviceCatalogService) {
        this.deviceCatalogService = deviceCatalogService;
    }

    @PostMapping
    public ResponseEntity<DeviceCatalogItem> createDevice(@RequestBody DeviceCatalogItem deviceCatalog) {
        return ResponseEntity.ok(deviceCatalogService.createDevice(deviceCatalog));
    }

    @GetMapping
    public ResponseEntity<List<DeviceCatalogItem>> getAllDevices() {
        return ResponseEntity.ok(deviceCatalogService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceCatalogItem> getDevice(@PathVariable Long id) {
        return ResponseEntity.ok(deviceCatalogService.getDeviceById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceCatalogService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
