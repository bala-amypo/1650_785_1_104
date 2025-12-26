package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository employeeRepo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile emp) {
        employeeRepo.findByEmployeeId(emp.getEmployeeId()).ifPresent(e -> {
            throw new BadRequestException("EmployeeId already exists");
        });
        employeeRepo.findByEmail(emp.getEmail()).ifPresent(e -> {
            throw new BadRequestException("Email already exists");
        });
        return employeeRepo.save(emp);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setActive(active);
        return employeeRepo.save(emp);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return employeeRepo.findAll();
    }
}
