// package com.example.demo.service.impl;

// import java.util.List;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.model.PolicyRule;
// import com.example.demo.service.PolicyRuleService;
// import org.springframework.stereotype.Service;
// @Service
// public class PolicyRuleServiceImpl implements PolicyRuleService {

//     private final PolicyRuleRepository repo;

//     public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
//         this.repo = repo;
//     }

//     public PolicyRule create(PolicyRule rule) {
//         return repo.save(rule);
//     }

//     public List<PolicyRule> getActiveRules() {
//         return repo.findByActiveTrue();
//     }

//     public List<PolicyRule> getAll() {
//         return repo.findAll();
//     }
// }
ackage com.example.demo.service.impl;

import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PolicyRule create(PolicyRule rule) {
        if (repository.existsByRuleCode(rule.getRuleCode())) {
            throw new BadRequestException("Rule code already exists");
        }
        return repository.save(rule);
    }

    @Override
    public List<PolicyRule> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.delete(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Policy rule not found"))
        );
    }
}