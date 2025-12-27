
// // package com.example.demo.controller;

// // import com.example.demo.model.IssuedDeviceRecord;
// // import com.example.demo.service.IssuedDeviceRecordService;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/api/issued-devices")
// // public class IssuedDeviceRecordController {

// //     @Autowired
// //     private IssuedDeviceRecordService service;

// //     @GetMapping("/count-active/{employeeId}")
// //     public int countActiveDevices(@PathVariable Long employeeId) {
// //         return service.countActiveDeviceForEmployee(employeeId);
// //     }

// //     @GetMapping("/employee/{employeeId}")
// //     public List<IssuedDeviceRecord> getDevices(@PathVariable Long employeeId) {
// //         return service.getDevicesByEmployeeId(employeeId);
// //     }

// //     @PostMapping
// //     public IssuedDeviceRecord issueDevice(@RequestBody IssuedDeviceRecord record) {
// //         return service.issueDevice(record);
// //     }

// //     @PutMapping("/deactivate/{id}")
// //     public void deactivateDevice(@PathVariable Long id) {
// //         service.deactivateDevice(id);
// //     }
// // // }
// // package com.example.demo.controller;

// // import com.example.demo.model.IssuedDeviceRecord;
// // import com.example.demo.service.IssuedDeviceRecordService;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/issued-devices")
// // public class IssuedDeviceRecordController {

// //     private final IssuedDeviceRecordService service;

// //     public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
// //         this.service = service;
// //     }

// //     @PutMapping("/{id}/return")
// //     public IssuedDeviceRecord returnDevice(@PathVariable Long id) {
// //         return service.returnDevice(id);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.IssuedDeviceRecord;
// import com.example.demo.service.IssuedDeviceRecordService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/issued-devices")
// public class IssuedDeviceRecordController {

//     private final IssuedDeviceRecordService service;

//     public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
//         this.service = service;
//     }

//     // ✅ Issue a device
//     @PostMapping
//     public ResponseEntity<IssuedDeviceRecord> issueDevice(
//             @RequestBody IssuedDeviceRecord record) {
//         return ResponseEntity.ok(service.issueDevice(record));
//     }

//     // ✅ Update issued/returned status
//     @PutMapping("/{id}/status")
//     public ResponseEntity<IssuedDeviceRecord> updateStatus(
//             @PathVariable Long id,
//             @RequestParam String status) {
//         return ResponseEntity.ok(service.updateStatus(id, status));
//     }

//     // ✅ Get record by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<IssuedDeviceRecord> getById(@PathVariable Long id) {
//         return ResponseEntity.ok(service.getById(id));
//     }

//     // ✅ Get all records
//     @GetMapping
//     public ResponseEntity<List<IssuedDeviceRecord>> getAll() {
//         return ResponseEntity.ok(service.getAllRecords());
//     }
// }

