
// // // package com.example.demo.controller;

// // // import com.example.demo.model.DeviceCatalogItem;
// // // import com.example.demo.service.DeviceCatalogService;
// // // import org.springframework.web.bind.annotation.*;

// // // import java.util.List;

// // // @RestController
// // // @RequestMapping("/devices")
// // // public class DeviceCatalogController {

// // //     private final DeviceCatalogService service;

// // //     public DeviceCatalogController(DeviceCatalogService service) {
// // //         this.service = service;
// // //     }

// // //     @PostMapping
// // //     public DeviceCatalogItem create(@RequestBody DeviceCatalogItem item) {
// // //         return service.create(item);
// // //     }

// // //     @GetMapping("/{id}")
// // //     public DeviceCatalogItem getById(@PathVariable Long id) {
// // //         return service.getById(id);
// // //     }

// // //     @GetMapping
// // //     public List<DeviceCatalogItem> getAll() {
// // //         return service.getAll();
// // //     }

// // //     @PutMapping("/{id}")
// // //     public DeviceCatalogItem update(@PathVariable Long id,
// // //                                     @RequestBody DeviceCatalogItem item) {
// // //         return service.update(id, item);
// // //     }

// // //     @DeleteMapping("/{id}")
// // //     public void delete(@PathVariable Long id) {
// // //         service.delete(id);
// // //     }
// // // }
// package com.example.demo.controller;

// import com.example.demo.model.DeviceCatalogItem;
// import com.example.demo.service.DeviceCatalogService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/devices")
// public class DeviceCatalogController {

//     private final DeviceCatalogService service;

//     public DeviceCatalogController(DeviceCatalogService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public DeviceCatalogItem createItem(@RequestBody DeviceCatalogItem item) {
//         return service.createItem(item);
//     }

//     @GetMapping
//     public List<DeviceCatalogItem> getAllItems() {
//         return service.getAllItems();
//     }

//     @PutMapping("/{id}/status")
//     public DeviceCatalogItem updateActiveStatus(
//             @PathVariable Long id,
//             @RequestParam boolean active) {
//         return service.updateActiveStatus(id, active);
//     }
// }
package com.example.demo.controller;

import java.util.List;

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

    // POST /api/devices
    @PostMapping
    public DeviceCatalogItem createDevice(
            @RequestBody DeviceCatalogItem item) {
        return service.createItem(item);
    }

    // GET /api/devices
    @GetMapping
    public List<DeviceCatalogItem> getAllDevices() {
        return service.getAllItems();
    }

    // GET /api/devices/{id}
    @GetMapping("/{id}")
    public DeviceCatalogItem getDeviceById(@PathVariable Long id) {
        return service.getItemById(id);
    }

    // PUT /api/devices/{id}/active?active=true
    @PutMapping("/{id}/active")
    public DeviceCatalogItem updateActiveStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateActiveStatus(id, active);
    }

    // DELETE /api/devices/{id}
    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        service.deleteItem(id);
    }
}
