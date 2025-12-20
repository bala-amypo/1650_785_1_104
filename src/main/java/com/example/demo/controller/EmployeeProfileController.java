package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;

@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile save(@RequestBody EmployeeProfile emp) {
        return service.save(emp);
    }

    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.findAll();
    }
}