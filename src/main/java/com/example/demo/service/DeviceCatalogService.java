// // com/example/demo/service/DeviceCatalogService.java
// package com.example.demo.service;

// import com.example.demo.model.DeviceCatalogItem;
// import java.util.List;

// public interface DeviceCatalogService {
//     DeviceCatalogItem createItem(DeviceCatalogItem item);
//     DeviceCatalogItem updateActiveStatus(Long id, boolean active);
//     List<DeviceCatalogItem> getAllItems();
// }
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {

        // ✅ ruleCode validation
        if (rule.getRuleCode() == null || rule.getRuleCode().isBlank()) {
            throw new BadRequestException("Rule code");
        }

        // ✅ Duplicate ruleCode
        if (repo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new BadRequestException("Rule code");
        }

        // ✅ maxDevicesAllowed validation
        if (rule.getMaxDevicesAllowed() != null && rule.getMaxDevicesAllowed() <= 0) {
            throw new BadRequestException("maxDevicesAllowed");
        }


        // ✅ default active
        if (rule.getActive() == null) {
            rule.setActive(true);
        }

        return repo.save(rule);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public PolicyRule updateRuleActive(Long id, boolean active) {
        PolicyRule rule = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy rule not found"));

        rule.setActive(active);
        return repo.save(rule);
    }

    @Override
    public void deleteRule(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Policy rule not found");
        }
        repo.deleteById(id);
    }
}
// deviceservice
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DeviceCatalogItem;

public interface DeviceCatalogService {

    DeviceCatalogItem createItem(DeviceCatalogItem item);

    DeviceCatalogItem updateActiveStatus(Long id, boolean active);

    List<DeviceCatalogItem> getAllItems();

    DeviceCatalogItem getItemById(Long id);

    void deleteItem(Long id);
}
