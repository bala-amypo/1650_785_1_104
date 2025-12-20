package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Issued;

public interface IssuedDeviceRecordService {
    IssuedDeviceRecord save(IssuedDeviceRecord r);
    List<IssuedDeviceRecord> findAll();
}