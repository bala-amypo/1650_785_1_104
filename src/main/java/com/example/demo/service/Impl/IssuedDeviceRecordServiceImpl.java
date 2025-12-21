package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;
@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {
    private final IssuedDeviceRecordRepository repo;
    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository repo) {
        this.repo = repo;
    }
    public IssuedDeviceRecord issue(IssuedDeviceRecord r) {
        return repo.save(r);
    }
    public List<IssuedDeviceRecord> getAll() {
        return repo.findAll();
    }
}