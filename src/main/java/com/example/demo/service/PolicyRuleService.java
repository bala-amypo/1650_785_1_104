package com.example.demo.service;

import java.util.List;
import com.example.demo.model.PolicyRule;
public interface PolicyRuleService {
    PolicyRule create(PolicyRule r);
    List<PolicyRule> getAll();
}
