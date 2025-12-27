// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.PolicyRule;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.service.PolicyRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class PolicyRuleServiceImpl implements PolicyRuleService {

//     private final PolicyRuleRepository policyRepo;

//     public PolicyRuleServiceImpl(PolicyRuleRepository policyRepo) {
//         this.policyRepo = policyRepo;
//     }

//     @Override
//     public PolicyRule createRule(PolicyRule rule) {
//         policyRepo.findByRuleCode(rule.getRuleCode()).ifPresent(r -> {
//             throw new BadRequestException("Rule code already exists");
//         });
//         return policyRepo.save(rule);
//     }

//     @Override
//     public List<PolicyRule> getAllRules() {
//         return policyRepo.findAll();
//     }

//     @Override
//     public List<PolicyRule> getActiveRules() {
//         return policyRepo.findByActiveTrue();
//     }
//      @Override
//     public void deleteRule(Long id) {
//         // delete logic here
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        // TODO: persist rule
        return rule;
    }

    @Override
    public List<PolicyRule> getAllRules() {
        // TODO: fetch from DB
        return new ArrayList<>();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        // TODO: filter active rules
        return new ArrayList<>();
    }

    @Override
    public PolicyRule updateRuleActive(Long id, boolean active) {
        // TODO: update active flag
        return null;
    }

    @Override
    public void deleteRule(Long id) {
        // TODO: delete rule by id
    }
}
