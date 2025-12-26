// com/example/demo/service/impl/IssuedDeviceRecordServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {
    
    private final IssuedDeviceRecordRepository issuedRepo;
    
    @Autowired
    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository issuedRepo) {
        this.issuedRepo = issuedRepo;
    }
    
    @Override
    public void returnDevice(Long recordId) {
        IssuedDeviceRecord record = issuedRepo.findById(recordId)
            .orElseThrow(() -> new RuntimeException("Record not found"));
        if ("RETURNED".equals(record.getStatus().name())) {
            throw new BadRequestException("Device already returned");
        }
        record.setStatus(IssuedDeviceRecord.DeviceStatus.RETURNED);
        issuedRepo.save(record);
    }
}
