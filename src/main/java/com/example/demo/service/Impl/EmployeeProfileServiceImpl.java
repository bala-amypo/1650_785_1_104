// package com.example.demo.serviceimpl;

// import com.example.demo.model.*;
// import com.example.demo.repositor.*;
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
        return repository.save(employee);
    }

    @Override
    public EmployeeProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public EmployeeProfile update(Long id, EmployeeProfile employee) {
        EmployeeProfile existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(employee.getName());
            existing.setDepartment(employee.getDepartment());
            existing.setActive(employee.isActive());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeProfile updateStatus(Long id, boolean active) {
        EmployeeProfile emp = repository.findById(id).orElse(null);
        if (emp != null) {
            emp.setActive(active);
            return repository.save(emp);
        }
        return null;
    }

    @Override
    public boolean existsByEmployeeId(String employeeId) {
        return repository.existsByEmployeeId(employeeId);
    }
}
