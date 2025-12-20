package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;
@Service

public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EligibilityCheckRecordRepository repo;

    public EligibilityCheckServiceImpl(EligibilityCheckRecordRepository repo) {
        this.repo = repo;
    }

    public EligibilityCheckRecord save(EligibilityCheckRecord e) {
        return repo.save(e);
    }

    public List<EligibilityCheckRecord> findAll() {
        return repo.findAll();
    }
}
