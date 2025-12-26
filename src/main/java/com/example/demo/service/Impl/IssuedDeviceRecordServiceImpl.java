// Update the constructor in IssuedDeviceRecordServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.repository.EmployeeProfileRepository;  // ADD THIS
import com.example.demo.repository.DeviceCatalogItemRepository;  // ADD THIS
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {
    
    private final IssuedDeviceRecordRepository issuedRepo;
    private final EmployeeProfileRepository employeeRepo;      // ADD THIS
    private final DeviceCatalogItemRepository deviceRepo;      // ADD THIS
    
    @Autowired
    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository issuedRepo,
                                       EmployeeProfileRepository employeeRepo,     // ADD THIS
                                       DeviceCatalogItemRepository deviceRepo) {    // ADD THIS
        this.issuedRepo = issuedRepo;
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
    }
    
    @Override
    public void returnDevice(Long recordId) {
        IssuedDeviceRecord record = issuedRepo.findById(recordId)
            .orElseThrow(() -> new RuntimeException("Record not found"));
        if (record.getStatus() == IssuedDeviceRecord.DeviceStatus.RETURNED) {
            throw new BadRequestException("Device already returned");
        }
        record.setStatus(IssuedDeviceRecord.DeviceStatus.RETURNED);
        issuedRepo.save(record);
    }
}
