package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface EmployeeProfileService {
    EmployeeProfile create(EmployeeProfile e);
    List<EmployeeProfile> getAll();
}