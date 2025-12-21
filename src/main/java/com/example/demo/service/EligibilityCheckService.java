package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EligibilityCheckRecord;
public interface EligibilityCheckService {
    EligibilityCheckRecord validate(Long employeeId, Long deviceItemId);
    List<EligibilityCheckRecord> getByEmployee(Long employeeId);
}