package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;
@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {
    private final PolicyRuleRepository repo;
    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }
    public PolicyRule create(PolicyRule r) {
        return repo.save(r);
    }
    public List<PolicyRule> getAll() {
        return repo.findAll();
    }
}
