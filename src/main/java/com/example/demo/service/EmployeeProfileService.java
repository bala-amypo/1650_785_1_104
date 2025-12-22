package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;
// public interface EmployeeProfileService {
//     EmployeeProfile create(EmployeeProfile employee);
//     EmployeeProfile getById(Long id);
//     EmployeeProfile updateStatus(Long id, Boolean active);
// }
// public interface EmployeeProfileService {
//     EmployeeProfile createEmployee(EmployeeProfile employee);
//     EmployeeProfile getEmployeeById(Long id);
//     List<EmployeeProfile> getAllEmployees();
//     void updateEmployeeStatus(Long id, boolean active);
// }
EmployeeProfile create(EmployeeProfile employee);

EmployeeProfile getById(Long id);

List<EmployeeProfile> getAll();

EmployeeProfile update(Long id, EmployeeProfile employee);

void delete(Long id);

EmployeeProfile updateStatus(Long id, boolean active); // if you use status update
