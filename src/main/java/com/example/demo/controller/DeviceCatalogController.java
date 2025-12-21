package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceCatalogController {

    private final DeviceCatalogService service;

    public DeviceCatalogController(DeviceCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceCatalogItem create(@RequestBody DeviceCatalogItem item) {
        return service.create(item);
    }

    @PutMapping("/{id}/active")
    public DeviceCatalogItem updateActive(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return service.updateActive(id, active);
    }

    @GetMapping
    public List<DeviceCatalogItem> getAll() {
        return service.getAll();
    }
}