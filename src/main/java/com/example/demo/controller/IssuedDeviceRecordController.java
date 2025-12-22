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
// // }
// package com.example.demo.controller;

// import com.example.demo.model.IssuedDeviceRecord;
// import com.example.demo.service.IssuedDeviceRecordService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/issued-devices")
// public class IssuedDeviceRecordController {

//     private final IssuedDeviceRecordService service;

//     public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public IssuedDeviceRecord issueDevice(@RequestBody IssuedDeviceRecord record) {
//         return service.issueDevice(record);
//     }

//     @PostMapping("/return/{id}")
//     public void returnDevice(@PathVariable Long id) {  // service return type must be void
//         service.returnDevice(id);
//     }

//     @GetMapping
//     public List<IssuedDeviceRecord> getAll() {
//         return service.getAll();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issued-devices")
public class IssuedDeviceRecordController {

    @Autowired
    private IssuedDeviceRecordService service;

    @GetMapping("/count-active/{employeeId}")
    public int countActiveDevices(@PathVariable Long employeeId) {
        return service.countActiveDeviceForEmployee(employeeId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<IssuedDeviceRecord> getDevices(@PathVariable Long employeeId) {
        return service.getDevicesByEmployeeId(employeeId);
    }

    @PostMapping
    public IssuedDeviceRecord issueDevice(@RequestBody IssuedDeviceRecord record) {
        return service.issueDevice(record);
    }

    @PutMapping("/deactivate/{id}")
    public void deactivateDevice(@PathVariable Long id) {
        service.deactivateDevice(id);
    }
}
