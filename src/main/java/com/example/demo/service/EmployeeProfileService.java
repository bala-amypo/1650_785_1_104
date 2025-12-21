package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;
public interface EmployeeProfileService {
    EmployeeProfile create(EmployeeProfile employee);
    EmployeeProfile getById(Long id);
    EmployeeProfile updateStatus(Long id, Boolean active);
}