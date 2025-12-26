// com/example/demo/service/impl/EligibilityCheckServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EligibilityCheckServiceImpl implements EligibilityCheckService {
    
    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;
    private final IssuedDeviceRecordRepository issuedRepo;
    private final PolicyRuleRepository policyRepo;
    private final EligibilityCheckRecordRepository eligibilityRepo;
    
    @Autowired
    public EligibilityCheckServiceImpl(EmployeeProfileRepository employeeRepo,
                                     DeviceCatalogItemRepository deviceRepo,
                                     IssuedDeviceRecordRepository issuedRepo,
                                     PolicyRuleRepository policyRepo,
                                     EligibilityCheckRecordRepository eligibilityRepo) {
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
        this.issuedRepo = issuedRepo;
        this.policyRepo = policyRepo;
        this.eligibilityRepo = eligibilityRepo;
    }
    
    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);
        
        // Check employee exists and active
        EmployeeProfile emp = employeeRepo.findById(employeeId).orElse(null);
        if (emp == null || !emp.getActive()) {
            record.setIsEligible(false);
            record.setReason("Employee not found or not active");
            return eligibilityRepo.save(record);
        }
        
        // Check device exists and active
        DeviceCatalogItem device = deviceRepo.findById(deviceItemId).orElse(null);
        if (device == null || !device.getActive()) {
            record.setIsEligible(false);
            record.setReason("Device not found or inactive");
            return eligibilityRepo.save(record);
        }
        
        // Check active issuance exists
        List<IssuedDeviceRecord> activeRecords = issuedRepo.findActiveByEmployeeAndDevice(employeeId, deviceItemId);
        if (!activeRecords.isEmpty()) {
            record.setIsEligible(false);
            record.setReason("Active issuance already exists for this employee and device");
            return eligibilityRepo.save(record);
        }
        
        // Check total device limit per device type
        long totalActiveDevices = issuedRepo.countActiveDevicesForEmployee(employeeId);
        if (totalActiveDevices >= device.getMaxAllowedPerEmployee()) {
            record.setIsEligible(false);
            record.setReason("Maximum allowed devices reached");
            return eligibilityRepo.save(record);
        }
        
        // Check policy rules
        List<PolicyRule> activeRules = policyRepo.findByActiveTrue();
        for (PolicyRule rule : activeRules) {
            boolean ruleApplies = true;
            
            if (rule.getAppliesToDepartment() != null && 
                !rule.getAppliesToDepartment().equals(emp.getDepartment())) {
                ruleApplies = false;
            }
            
            if (rule.getAppliesToRole() != null && 
                !rule.getAppliesToRole().equals(emp.getJobRole())) {
                ruleApplies = false;
            }
            
            if (ruleApplies && totalActiveDevices >= rule.getMaxDevicesAllowed()) {
                record.setIsEligible(false);
                record.setReason("Policy violation: " + rule.getRuleCode());
                return eligibilityRepo.save(record);
            }
        }
        
        // All checks passed
        record.setIsEligible(true);
        record.setReason("Eligible");
        return eligibilityRepo.save(record);
    }
    
    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return eligibilityRepo.findByEmployeeId(employeeId);
    }
}
