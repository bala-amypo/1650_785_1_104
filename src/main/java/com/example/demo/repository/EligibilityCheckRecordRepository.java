package com.example.demo.repository;

import com.example.demo.model.EligibilityCheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;  // ✅ THIS IS REQUIRED

public interface EligibilityCheckRecordRepository
        extends JpaRepository<EligibilityCheckRecord, Long> {

    List<EligibilityCheckRecord> findByEmployeeId(Long employeeId);
}
