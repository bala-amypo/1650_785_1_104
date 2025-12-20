package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.IssuedDeviceRecord;
public interface IssuedDeviceRecordRepository
        extends JpaRepository<IssuedDeviceRecord, Long> {

    Long countActiveDevicesForEmployee(Long employeeId);

    java.util.List<IssuedDeviceRecord> findActiveByEmployeeAndDevice(
            Long employeeId, Long deviceItemId);
}