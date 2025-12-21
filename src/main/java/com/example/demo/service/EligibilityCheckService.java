package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EligibilityCheckRecord;
public interface EligibilityCheckService {
    EligibilityCheckRecord create(EligibilityCheckRecord e);
    List<EligibilityCheckRecord> getAll();
}