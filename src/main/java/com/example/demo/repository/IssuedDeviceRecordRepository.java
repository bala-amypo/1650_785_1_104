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
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {

    // Count active devices for a specific employee
    @Query("SELECT COUNT(r) FROM IssuedDeviceRecord r WHERE r.employeeId = :employeeId AND r.active = true")
    int countActiveDeviceForEmployee(@Param("employeeId") Long employeeId);

    // Get all issued devices for an employee
    List<IssuedDeviceRecord> findByEmployeeId(Long employeeId);
}
