
// package com.example.demo.service.impl;

// import com.example.demo.model.PolicyRule;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.service.PolicyRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class PolicyRuleServiceImpl implements PolicyRuleService {

//     private final PolicyRuleRepository repository;

//     public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public PolicyRule create(PolicyRule rule) {
//         if (repository.existsByRuleCode(rule.getRuleCode())) {
//             throw new RuntimeException("Rule with code already exists");
//         }
//         return repository.save(rule);
//     }

//     @Override
//     public List<PolicyRule> getAll() {
//         return repository.findAll();
//     }

//     @Override
//     public void delete(Long id) {
//         repository.deleteById(id);
//     }

//     @Override
//     public List<PolicyRule> getActiveRules() {
//         return repository.findByActiveTrue();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    public PolicyRule createRule(PolicyRule rule) {
        repo.findByRuleCode(rule.getRuleCode())
                .ifPresent(r -> { throw new BadRequestException("Rule code already exists"); });
        return repo.save(rule);
    }

    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }
}