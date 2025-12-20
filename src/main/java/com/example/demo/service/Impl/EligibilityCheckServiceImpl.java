package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckRecordService;

public class EligibilityCheckRecordServiceImpl implements EligibilityCheckRecordService {

    private final EligibilityCheckRecordRepository repo;

    public EligibilityCheckRecordServiceImpl(EligibilityCheckRecordRepository repo) {
        this.repo = repo;
    }

    public EligibilityCheckRecord save(EligibilityCheckRecord e) {
        return repo.save(e);
    }

    public List<EligibilityCheckRecord> findAll() {
        return repo.findAll();
    }
}
