package com.example.demo.service;

import java.util.List;
import com.example.demo.model.IssuedDeviceRecord;
public interface IssuedDeviceRecordService {
    IssuedDeviceRecord issue(IssuedDeviceRecord record);
    IssuedDeviceRecord returnDevice(Long id);
    List<IssuedDeviceRecord> getByEmployee(Long employeeId);
}