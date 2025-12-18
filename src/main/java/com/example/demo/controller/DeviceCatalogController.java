package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;

@RestController
@RequestMapping("/api/devices")
public class DeviceCatalogController {

    private final DeviceCatalogService service;

    public DeviceCatalogController(DeviceCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceCatalogItem> create(@RequestBody DeviceCatalogItem item) {
        return ResponseEntity.ok(service.createItem(item));
    }

    @GetMapping
    public ResponseEntity<List<DeviceCatalogItem>> getAll() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @PutMapping("/{id}/active")
    public ResponseEntity<DeviceCatalogItem> updateActive(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return ResponseEntity.ok(service.updateActiveStatus(id, active));
    }
}
