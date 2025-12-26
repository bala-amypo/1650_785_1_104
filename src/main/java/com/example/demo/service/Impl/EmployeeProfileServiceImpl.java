// com/example/demo/service/impl/EmployeeProfileServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class EmployeeProfileServiceImpl implements EmployeeProfileService {
    
    private final EmployeeProfileRepository employeeRepo;
    
    @Autowired
    public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    
    @Override
    public EmployeeProfile createEmployee(EmployeeProfile emp) {
        if (employeeRepo.findByEmployeeId(emp.getEmployeeId()).isPresent()) {
            throw new BadRequestException("EmployeeId already exists");
        }
        if (employeeRepo.findByEmail(emp.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }
        emp.setCreatedAt(LocalDateTime.now());
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
