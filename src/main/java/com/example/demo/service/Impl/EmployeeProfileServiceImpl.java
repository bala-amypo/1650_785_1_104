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

    public EmployeeProfile create(EmployeeProfile employee) {
        return repo.save(employee);
    }

    public EmployeeProfile getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public EmployeeProfile updateStatus(Long id, Boolean active) {
        EmployeeProfile emp = repo.findById(id).orElse(null);
        if (emp != null) {
            emp.setActive(active);
            return repo.save(emp);
        }
        return null;
    }
}
