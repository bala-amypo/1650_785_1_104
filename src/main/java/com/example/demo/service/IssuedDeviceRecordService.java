
// // package com.example.demo.service;

// // import com.example.demo.model.IssuedDeviceRecord;

// // import java.util.List;

// // public interface IssuedDeviceRecordService {

// //     int countActiveDeviceForEmployee(Long employeeId);

// //     List<IssuedDeviceRecord> getDevicesByEmployeeId(Long employeeId);

// //     IssuedDeviceRecord issueDevice(IssuedDeviceRecord record);

// //     void deactivateDevice(Long id);
// // // }
// // public interface IssuedDeviceRecordService {
// //     IssuedDeviceRecord returnDevice(Long id);
// // }

// package com.example.demo.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.IssuedDeviceRecord;
// import com.example.demo.repository.IssuedDeviceRecordRepository;

// @Service
// public class IssuedDeviceRecordService {

//     private final IssuedDeviceRecordRepository repository;

//     public IssuedDeviceRecordService(IssuedDeviceRecordRepository repository) {
//         this.repository = repository;
//     }

//     public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
//         return repository.save(record);
//     }

//     public IssuedDeviceRecord updateStatus(Long id, String status) {
//         IssuedDeviceRecord record = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Record not found"));

//         record.setStatus(status);
//         return repository.save(record);
//     }

//     public IssuedDeviceRecord getById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Record not found"));
//     }

//     public List<IssuedDeviceRecord> getAllRecords() {
//         return repository.findAll();
//     }
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.IssuedDeviceRecord;

public interface IssuedDeviceRecordService {

    IssuedDeviceRecord issueDevice(IssuedDeviceRecord record);

    IssuedDeviceRecord updateStatus(Long id, String status);

    IssuedDeviceRecord getById(Long id);

    List<IssuedDeviceRecord> getAllRecords();
}
