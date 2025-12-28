
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

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-catalog")
public class DeviceCatalogController {

    private final DeviceCatalogService deviceCatalogService;

    public DeviceCatalogController(DeviceCatalogService deviceCatalogService) {
        this.deviceCatalogService = deviceCatalogService;
    }

   
    @PostMapping
    public DeviceCatalogItem createItem(@RequestBody DeviceCatalogItem item) {
        return deviceCatalogService.createItem(item);
    }

   
    @GetMapping
    public List<DeviceCatalogItem> getAllItems() {
        return deviceCatalogService.getAllItems();
    }

    
    @PutMapping("/{id}/active")
    public DeviceCatalogItem updateActiveStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return deviceCatalogService.updateActiveStatus(id, active);
    }
}
