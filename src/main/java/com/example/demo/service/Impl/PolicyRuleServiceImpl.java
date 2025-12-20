package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;

public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    public PolicyRule save(PolicyRule p) {
        return repo.save(p);
    }

    public List<PolicyRule> findAll() {
        return repo.findAll();
    }
}
