package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EmployeeProfile;

public interface EmployeeProfileService {
    EmployeeProfile save(EmployeeProfile e);
    List<EmployeeProfile> findAll();
} 