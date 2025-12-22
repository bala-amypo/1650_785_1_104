package com.example.demo.controller;

import com.example.demo.entity.DeviceCatalog;
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
    public ResponseEntity<DeviceCatalog> createDevice(@RequestBody DeviceCatalog deviceCatalog) {
        return ResponseEntity.ok(deviceCatalogService.createDevice(deviceCatalog));
    }

    @GetMapping
    public ResponseEntity<List<DeviceCatalog>> getAllDevices() {
        return ResponseEntity.ok(deviceCatalogService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceCatalog> getDevice(@PathVariable Long id) {
        return ResponseEntity.ok(deviceCatalogService.getDeviceById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceCatalogService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
