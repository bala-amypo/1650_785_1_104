package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;

public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    public PolicyRule createRule(PolicyRule rule) {

        repo.findByRuleCode(rule.getRuleCode())
                .ifPresent(r -> { throw new BadRequestException("Rule code"); });

        return repo.save(rule);
    }

    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }

    public List<PolicyRule> getActiveRules() {
        return repo.findByActiveTrue();
    }
}
