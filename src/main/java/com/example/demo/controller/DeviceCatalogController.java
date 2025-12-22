package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device-catalog")
public class DeviceCatalogItemController {

    private final DeviceCatalogItemService service;

    public DeviceCatalogItemController(DeviceCatalogItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceCatalogItem> create(
            @RequestBody DeviceCatalogItem item) {
        return ResponseEntity.ok(service.createDevice(item));
    }

    @GetMapping
    public ResponseEntity<List<DeviceCatalogItem>> getAll() {
        return ResponseEntity.ok(service.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceCatalogItem> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDeviceById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
