package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;
@Service
public class IssuedDeviceRecordServiceImpl
        implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository repo;

    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository repo) {
        this.repo = repo;
    }

    public IssuedDeviceRecord issue(IssuedDeviceRecord record) {
        record.setReturned(false);
        return repo.save(record);
    }

    public IssuedDeviceRecord returnDevice(Long id) {
        IssuedDeviceRecord record = repo.findById(id).orElse(null);
        if (record != null) {
            record.setReturned(true);
            return repo.save(record);
        }
        return null;
    }

    public List<IssuedDeviceRecord> getByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }
}
