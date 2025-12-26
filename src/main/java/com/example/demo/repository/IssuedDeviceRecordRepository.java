package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {

    @Query("select count(r) from IssuedDeviceRecord r " +
           "where r.employeeId = :employeeId and r.status = 'ISSUED'")
    long countActiveDevicesForEmployee(@Param("employeeId") Long employeeId);

    @Query("select r from IssuedDeviceRecord r " +
           "where r.employeeId = :employeeId and r.deviceItemId = :deviceItemId " +
           "and r.status = 'ISSUED'")
    List<IssuedDeviceRecord> findActiveByEmployeeAndDevice(@Param("employeeId") Long employeeId,
                                                           @Param("deviceItemId") Long deviceItemId);
}
