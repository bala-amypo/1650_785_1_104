package com.example.demo.serviceimpl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {
    private final EmployeeProfileRepository repo;
    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }
    public EmployeeProfile create(EmployeeProfile e) {
        return repo.save(e);
    }
    public List<EmployeeProfile> getAll() {
        return repo.findAll();
    }
}
