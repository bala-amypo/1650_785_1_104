// package com.example.demo.serviceimpl;

// import com.example.demo.model.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.*;
// import org.springframework.stereotype.Service;
// import java.util.List;
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

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile create(EmployeeProfile employee) {
        if (repository.existsByEmployeeId(employee.getEmployeeId())) {
            throw new BadRequestException("Employee ID already exists");
        }
        return repository.save(employee);
    }

    @Override
    public EmployeeProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public EmployeeProfile update(Long id, EmployeeProfile updated) {
        EmployeeProfile existing = getById(id);
        existing.setFullName(updated.getFullName());
        existing.setDepartment(updated.getDepartment());
        existing.setJobRole(updated.getJobRole());
        existing.setActive(updated.getActive());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}