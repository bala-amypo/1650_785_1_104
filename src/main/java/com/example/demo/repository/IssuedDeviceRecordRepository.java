package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// public interface IssuedDeviceRecordRepository
//         extends JpaRepository<IssuedDeviceRecord, Long> {

//     List<IssuedDeviceRecord> findByEmployeeId(Long employeeId);
// }
public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {
    int countActiveDeviceForEmployee(Long employeeId);
    Optional<IssuedDeviceRecord> findActiveByEmployeeAndDevice(Long employeeId, Long deviceItemId);
}