package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.exception.*;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    public EmployeeProfile createEmployee(EmployeeProfile emp) {

        if (repo.findByEmployeeId(emp.getEmployeeId()).isPresent()) {
            throw new BadRequestException("EmployeeId already exists");
        }
        if (repo.findByEmail(emp.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }
        return repo.save(emp);
    }

    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = getEmployeeById(id);
        emp.setActive(active);
        return repo.save(emp);
    }
}
