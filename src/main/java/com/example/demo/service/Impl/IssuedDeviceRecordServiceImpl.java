
// // // package com.example.demo.service.impl;

// // // import com.example.demo.model.IssuedDeviceRecord;
// // // import com.example.demo.repository.IssuedDeviceRecordRepository;
// // // import com.example.demo.service.IssuedDeviceRecordService;
// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.stereotype.Service;

// // // import java.util.List;

// // // @Service
// // // public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

// // //     @Autowired
// // //     private IssuedDeviceRecordRepository repository;

// // //     @Override
// // //     public int countActiveDeviceForEmployee(Long employeeId) {
// // //         return repository.countActiveDeviceForEmployee(employeeId);
// // //     }

// // //     @Override
// // //     public List<IssuedDeviceRecord> getDevicesByEmployeeId(Long employeeId) {
// // //         return repository.findByEmployeeId(employeeId);
// // //     }

// // //     @Override
// // //     public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
// // //         record.setActive(true);
// // //         return repository.save(record);
// // //     }

// // //     @Override
// // //     public void deactivateDevice(Long id) {
// // //         IssuedDeviceRecord record = repository.findById(id)
// // //                 .orElseThrow(() -> new RuntimeException("Device record not found"));
// // //         record.setActive(false);
// // //         repository.save(record);
// // // //     }
// // // // }
// // // package com.example.demo.service.impl;

// // // import com.example.demo.exception.BadRequestException;
// // // import com.example.demo.model.IssuedDeviceRecord;
// // // import com.example.demo.repository.*;
// // // import com.example.demo.service.IssuedDeviceRecordService;

// // // public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

// // //     private final IssuedDeviceRecordRepository repo;

// // //     public IssuedDeviceRecordServiceImpl(
// // //             IssuedDeviceRecordRepository repo,
// // //             EmployeeProfileRepository e,
// // //             DeviceCatalogItemRepository d) {
// // //         this.repo = repo;
// // //     }

// // //     public IssuedDeviceRecord returnDevice(Long id) {
// // //         IssuedDeviceRecord r = repo.findById(id)
// // //                 .orElseThrow(() -> new BadRequestException("Record not found"));

// // //         if ("RETURNED".equals(r.getStatus()))
// // //             throw new BadRequestException("Device already returned");

// // //         r.setStatus("RETURNED");
// // //         return repo.save(r);
// // //     }
// // package com.example.demo.service.impl;

// // import com.example.demo.exception.BadRequestException;
// // import com.example.demo.model.IssuedDeviceRecord;
// // import com.example.demo.repository.IssuedDeviceRecordRepository;
// // import com.example.demo.repository.EmployeeProfileRepository;
// // import com.example.demo.repository.DeviceCatalogItemRepository;
// // import com.example.demo.service.IssuedDeviceRecordService;

// // public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {
// //     private final IssuedDeviceRecordRepository issuedRepo;
// //     private final EmployeeProfileRepository employeeRepo;
// //     private final DeviceCatalogItemRepository deviceRepo;

// //     public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository issuedRepo, 
// //                                        EmployeeProfileRepository employeeRepo,
// //                                        DeviceCatalogItemRepository deviceRepo) {
// //         this.issuedRepo = issuedRepo;
// //         this.employeeRepo = employeeRepo;
// //         this.deviceRepo = deviceRepo;
// //     }

// //     @Override
// //     public IssuedDeviceRecord returnDevice(Long id) {
// //         IssuedDeviceRecord record = issuedRepo.findById(id)
// //                 .orElseThrow(() -> new RuntimeException("Record not found"));
// //         if ("RETURNED".equals(record.getStatus())) {
// //             throw new BadRequestException("Device already returned");
// //         }
// //         record.setStatus("RETURNED");
// //         return issuedRepo.save(record);
// //     }
// // }
// package com.example.demo.service.Impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.IssuedDeviceRecord;
// import com.example.demo.repository.IssuedDeviceRecordRepository;
// import com.example.demo.service.IssuedDeviceRecordService;

// @Service
// public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

//     private final IssuedDeviceRecordRepository repository;

//     public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
//         return repository.save(record);
//     }

//     @Override
//     public IssuedDeviceRecord updateStatus(Long id, String status) {
//         IssuedDeviceRecord record = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Record not found"));

//         record.setStatus(status);
//         return repository.save(record);
//     }

//     @Override
//     public IssuedDeviceRecord getById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Record not found"));
//     }

//     @Override
//     public List<IssuedDeviceRecord> getAllRecords() {
//         return repository.findAll();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {
    private final IssuedDeviceRecordRepository issuedRepo;
    @SuppressWarnings("unused")
    private final EmployeeProfileRepository employeeRepo;
    @SuppressWarnings("unused")
    private final DeviceCatalogItemRepository deviceRepo;

    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository issuedRepo, 
                                       EmployeeProfileRepository employeeRepo,
                                       DeviceCatalogItemRepository deviceRepo) {
        this.issuedRepo = issuedRepo;
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public IssuedDeviceRecord returnDevice(Long id) {
        IssuedDeviceRecord record = issuedRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
        if ("RETURNED".equals(record.getStatus())) {
            throw new BadRequestException("Device already returned");
        }
        record.setStatus("RETURNED");
        return issuedRepo.save(record);
    }

    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
        return issuedRepo.save(record);
    }

    @Override
    public IssuedDeviceRecord updateStatus(Long id, String status) {
        IssuedDeviceRecord record = issuedRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
        record.setStatus(status);
        return issuedRepo.save(record);
    }

    @Override
    public IssuedDeviceRecord getById(Long id) {
        return issuedRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<IssuedDeviceRecord> getAllRecords() {
        return issuedRepo.findAll();
    }
}