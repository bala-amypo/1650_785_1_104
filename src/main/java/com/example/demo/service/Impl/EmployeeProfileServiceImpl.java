package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;
@Service

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    public EmployeeProfile save(EmployeeProfile e) {
        return repo.save(e);
    }

    public List<EmployeeProfile> findAll() {
        return repo.findAll();
    }
}