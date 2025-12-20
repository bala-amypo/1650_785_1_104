package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.exception.*;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.*;
import com.example.demo.service.IssuedDeviceRecordService;

public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository repo;
    private final EmployeeProfileRepository empRepo;
    private final DeviceCatalogItemRepository devRepo;

    public IssuedDeviceRecordServiceImpl(
            IssuedDeviceRecordRepository repo,
            EmployeeProfileRepository empRepo,
            DeviceCatalogItemRepository devRepo) {

        this.repo = repo;
        this.empRepo = empRepo;
        this.devRepo = devRepo;
    }

    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {

        empRepo.findById(record.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        devRepo.findById(record.getDeviceItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        record.setIssuedDate(LocalDate.now());
        record.setStatus("ISSUED");
        return repo.save(record);
    }

    public IssuedDeviceRecord returnDevice(Long recordId) {

        IssuedDeviceRecord rec = repo.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));

        if ("RETURNED".equals(rec.getStatus())) {
            throw new BadRequestException("already returned");
        }

        rec.setReturnedDate(LocalDate.now());
        rec.setStatus("RETURNED");
        return repo.save(rec);
    }

    public List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }
}
