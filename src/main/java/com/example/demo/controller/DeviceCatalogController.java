// package com.example.demo.controller;

// import com.example.demo.model.DeviceCatalogItem;
// import com.example.demo.service.DeviceCatalogService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/device-catalog")
// public class DeviceCatalogController {

//     private final DeviceCatalogService deviceCatalogService;

//     public DeviceCatalogController(DeviceCatalogService deviceCatalogService) {
//         this.deviceCatalogService = deviceCatalogService;
//     }

//     @PostMapping
//     public ResponseEntity<DeviceCatalogItem> createDevice(@RequestBody DeviceCatalogItem item) {
//         return ResponseEntity.ok(deviceCatalogService.createDevice(item));
//     }

//     @GetMapping
//     public ResponseEntity<List<DeviceCatalogItem>> getAllDevices() {
//         return ResponseEntity.ok(deviceCatalogService.getAllDevices());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<DeviceCatalogItem> getDeviceById(@PathVariable Long id) {
//         return ResponseEntity.ok(deviceCatalogService.getDeviceById(id));
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
//         deviceCatalogService.deleteDevice(id);
//         return ResponseEntity.noContent().build();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceCatalogController {

    private final DeviceCatalogService service;

    public DeviceCatalogController(DeviceCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceCatalogItem create(@RequestBody DeviceCatalogItem item) {
        return service.create(item);
    }

    @GetMapping("/{id}")
    public DeviceCatalogItem getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<DeviceCatalogItem> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}