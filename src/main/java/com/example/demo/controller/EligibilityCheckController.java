package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;

@RestController
@RequestMapping("/eligibility")
public class EligibilityCheckController {

    private final EligibilityCheckService service;

    public EligibilityCheckController(EligibilityCheckService service) {
        this.service = service;
    }

    @PostMapping
    public EligibilityCheckRecord save(@RequestBody EligibilityCheckRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<EligibilityCheckRecord> getAll() {
        return service.findAll();
    }
}