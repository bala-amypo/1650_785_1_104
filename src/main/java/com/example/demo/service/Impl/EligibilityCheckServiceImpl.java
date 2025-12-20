package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.EligibilityCheckRepository;
import com.example.demo.model.EligibilityCheck;
import com.example.demo.service.EligibilityCheckService;

public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EligibilityCheckRepository repo;

    public EligibilityCheckServiceImpl(EligibilityCheckRepository repo) {
        this.repo = repo;
    }

    public EligibilityCheck save(EligibilityCheck e) {
        return repo.save(e);
    }

    public List<EligibilityCheck> findAll() {
        return repo.findAll();
    }
}
