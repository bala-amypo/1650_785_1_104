// package com.example.demo.repository;
// import java.util.Optional;

// import com.example.demo.model.IssuedDeviceRecord;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface IssuedDeviceRecordRepository
//         extends JpaRepository<IssuedDeviceRecord, Long> {

//     List<IssuedDeviceRecord> findByEmployeeId(Long employeeId);
// }
// public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {
//     int countActiveDeviceForEmployee(Long employeeId);
//     List<IssuedDeviceRecord> findByEmployeeId(Long employeeId);

//     Optional<IssuedDeviceRecord> findActiveByEmployeeAndDevice(Long employeeId, Long deviceItemId);
// }

package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {
    @Query("SELECT COUNT(r) FROM IssuedDeviceRecord r WHERE r.employeeId = ?1 AND r.status = 'ISSUED'")
    Long countActiveDevicesForEmployee(Long employeeId);
    
    @Query("SELECT r FROM IssuedDeviceRecord r WHERE r.employeeId = ?1 AND r.deviceItemId = ?2 AND r.status = 'ISSUED'")
    List<IssuedDeviceRecord> findActiveByEmployeeAndDevice(Long employeeId, Long deviceItemId);
}