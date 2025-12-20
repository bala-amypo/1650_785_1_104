package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;

@RestController
@RequestMapping("/policies")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyRule save(@RequestBody PolicyRule rule) {
        return service.save(rule);
    }

    @GetMapping
    public List<PolicyRule> getAll() {
        return service.findAll();
    }
}