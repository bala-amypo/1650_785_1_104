package com.example.demo.serviceimpl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.util.List;
// @Service
// public class EmployeeProfileServiceImpl implements EmployeeProfileService {

//     private final EmployeeProfileRepository repo;

//     public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
//         this.repo = repo;
//     }

//     public EmployeeProfile create(EmployeeProfile employee) {
//         return repo.save(employee);
//     }

//     public EmployeeProfile getById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     public EmployeeProfile updateStatus(Long id, Boolean active) {
//         EmployeeProfile emp = repo.findById(id).orElse(null);
//         if (emp != null) {
//             emp.setActive(active);
//             return repo.save(emp);
//         }
//         return null;
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.service.*;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.exception.*;
import java.util.*;

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        if (repo.findByEmployeeId(employee.getEmployeeId()).isPresent()) {
            throw new BadRequestException("employeeId already exists");
        }
        return repo.save(employee);
    }

    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    public void updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = getEmployeeById(id);
        e.setActive(active);
        repo.save(e);
    }
}