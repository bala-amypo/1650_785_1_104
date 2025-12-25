
// package com.example.demo.service.impl;

// import com.example.demo.model.IssuedDeviceRecord;
// import com.example.demo.repository.IssuedDeviceRecordRepository;
// import com.example.demo.service.IssuedDeviceRecordService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

//     @Autowired
//     private IssuedDeviceRecordRepository repository;

//     @Override
//     public int countActiveDeviceForEmployee(Long employeeId) {
//         return repository.countActiveDeviceForEmployee(employeeId);
//     }

//     @Override
//     public List<IssuedDeviceRecord> getDevicesByEmployeeId(Long employeeId) {
//         return repository.findByEmployeeId(employeeId);
//     }

//     @Override
//     public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
//         record.setActive(true);
//         return repository.save(record);
//     }

//     @Override
//     public void deactivateDevice(Long id) {
//         IssuedDeviceRecord record = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Device record not found"));
//         record.setActive(false);
//         repository.save(record);
// //     }
// // }
// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.IssuedDeviceRecord;
// import com.example.demo.repository.*;
// import com.example.demo.service.IssuedDeviceRecordService;

// public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

//     private final IssuedDeviceRecordRepository repo;

//     public IssuedDeviceRecordServiceImpl(
//             IssuedDeviceRecordRepository repo,
//             EmployeeProfileRepository e,
//             DeviceCatalogItemRepository d) {
//         this.repo = repo;
//     }

//     public IssuedDeviceRecord returnDevice(Long id) {
//         IssuedDeviceRecord r = repo.findById(id)
//                 .orElseThrow(() -> new BadRequestException("Record not found"));

//         if ("RETURNED".equals(r.getStatus()))
//             throw new BadRequestException("Device already returned");

//         r.setStatus("RETURNED");
//         return repo.save(r);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository repository;

    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
        record.setStatus("ISSUED");
        return repository.save(record);
    }

    @Override
    public IssuedDeviceRecord updateStatus(Long id, String status) {
        IssuedDeviceRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issued record not found"));

        record.setStatus(status);
        return repository.save(record);
    }

    @Override
    public IssuedDeviceRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issued record not found"));
    }

    @Override
    public List<IssuedDeviceRecord> getAllRecords() {
        return repository.findAll();
    }
}
