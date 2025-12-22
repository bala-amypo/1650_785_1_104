// package com.example.demo.controller;

// import com.example.demo.model.IssuedDeviceRecord;
// import com.example.demo.service.IssuedDeviceRecordService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/issued-devices")
// public class IssuedDeviceRecordController {

//     private final IssuedDeviceRecordService service;

//     public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public IssuedDeviceRecord issue(@RequestBody IssuedDeviceRecord record) {
//         return service.issue(record);
//     }

//     @PutMapping("/{id}/return")
//     public IssuedDeviceRecord returnDevice(@PathVariable Long id) {
//         return service.returnDevice(id);
//     }

//     @GetMapping("/employee/{employeeId}")
//     public List<IssuedDeviceRecord> getByEmployee(@PathVariable Long employeeId) {
//         return service.getByEmployee(employeeId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issued-devices")
public class IssuedDeviceRecordController {

    private final IssuedDeviceRecordService service;

    public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
        this.service = service;
    }

    @PostMapping
    public IssuedDeviceRecord issue(@RequestBody IssuedDeviceRecord record) {
        return service.issueDevice(record);
    }

    @PutMapping("/return/{id}")
    public IssuedDeviceRecord returnDevice(@PathVariable Long id) {
        return service.returnDevice(id);
    }

    @GetMapping
    public List<IssuedDeviceRecord> getAll() {
        return service.getAll();
    }
}