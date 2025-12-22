// package com.example.demo.service.impl;

// import java.util.List;
// import com.example.demo.repository.EligibilityCheckRecordRepository;
// import com.example.demo.model.EligibilityCheckRecord;
// import com.example.demo.service.EligibilityCheckService;
// import org.springframework.stereotype.Service;
// @Service
// public class EligibilityCheckServiceImpl
//         implements EligibilityCheckService {

//     private final EligibilityCheckRecordRepository repo;

//     public EligibilityCheckServiceImpl(
//             EligibilityCheckRecordRepository repo) {
//         this.repo = repo;
//     }

//     public EligibilityCheckRecord validate(
//             Long employeeId, Long deviceItemId) {

//         EligibilityCheckRecord record =
//                 new EligibilityCheckRecord();

//         record.setEmployeeId(employeeId);
//         record.setDeviceItemId(deviceItemId);
//         record.setIsEligible(true);
//         record.setReason("Allowed");

//         return repo.save(record);
//     }

//     public List<EligibilityCheckRecord> getByEmployee(Long employeeId) {
//         return repo.findByEmployeeId(employeeId);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EligibilityCheckRecordRepository repository;

    public EligibilityCheckServiceImpl(EligibilityCheckRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EligibilityCheckRecord validate(Long employeeId, Long deviceItemId) {
        // Your validation logic here
        return repository.validate(employeeId, deviceItemId);
    }

    @Override
    public List<EligibilityCheckRecord> getByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public EligibilityCheckRecord save(EligibilityCheckRecord record) {
        return repository.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getAll() {
        return repository.findAll();
    }
}
