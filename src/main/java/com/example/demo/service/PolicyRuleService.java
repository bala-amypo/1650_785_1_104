package com.example.demo.service;

import java.util.List;
import com.example.demo.model.PolicyRule;
public interface PolicyRuleService {
    PolicyRule create(PolicyRule rule);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAll();
}