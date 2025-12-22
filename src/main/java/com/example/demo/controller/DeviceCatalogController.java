package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device-catalog")
public class DeviceCatalogController {

    private final DeviceCatalogItemService deviceCatalogItemService;

    public DeviceCatalogController(DeviceCatalogItemService deviceCatalogItemService) {
        this.deviceCatalogItemService = deviceCatalogItemService;
    }

    @PostMapping
    public ResponseEntity<DeviceCatalogItem> createDevice(@RequestBody DeviceCatalogItem item) {
        return ResponseEntity.ok(deviceCatalogItemService.createDevice(item));
    }

    @GetMapping
    public ResponseEntity<List<DeviceCatalogItem>> getAllDevices() {
        return ResponseEntity.ok(deviceCatalogItemService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceCatalogItem> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceCatalogItemService.getDeviceById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceCatalogItemService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
