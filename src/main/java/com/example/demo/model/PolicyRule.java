// com/example/demo/model/PolicyRule.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "policy_rules", uniqueConstraints = @UniqueConstraint(columnNames = "ruleCode"))
public class PolicyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String ruleCode;
    
    private String appliesToDepartment;
    private String appliesToRole;
    
    private int maxDevicesAllowed;
    private boolean active = true;
    
    // Constructors
    public PolicyRule() {}
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public String getAppliesToDepartment() { return appliesToDepartment; }
    public void setAppliesToDepartment(String appliesToDepartment) { this.appliesToDepartment = appliesToDepartment; }
    public String getAppliesToRole() { return appliesToRole; }
    public void setAppliesToRole(String appliesToRole) { this.appliesToRole = appliesToRole; }
    public int getMaxDevicesAllowed() { return maxDevicesAllowed; }
    public void setMaxDevicesAllowed(int maxDevicesAllowed) { this.maxDevicesAllowed = maxDevicesAllowed; }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
