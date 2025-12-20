package com.example.demo.service;

import java.util.List;
import com.example.demo.model.PolicyRule;

public interface PolicyRuleService {
    PolicyRule save(PolicyRule p);
    List<PolicyRule> findAll();
}