package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository issuedRepo;
    private final EmployeeProfileRepository employeeRepo;
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
        IssuedDeviceRecord rec = issuedRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Issued record not found"));
        if ("RETURNED".equalsIgnoreCase(rec.getStatus())) {
            throw new BadRequestException("Device already returned");
        }
        rec.setStatus("RETURNED");
        return issuedRepo.save(rec);
    }
}
