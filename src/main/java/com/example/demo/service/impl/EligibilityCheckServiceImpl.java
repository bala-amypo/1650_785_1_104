package com.example.demo.service.impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.PolicyRule;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;
    private final IssuedDeviceRecordRepository issuedRepo;
    private final PolicyRuleRepository policyRepo;
    private final EligibilityCheckRecordRepository eligibilityRepo;

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
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return eligibilityRepo.findByEmployeeId(employeeId);
    }

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EligibilityCheckRecord rec = new EligibilityCheckRecord();
        rec.setEmployeeId(employeeId);
        rec.setDeviceItemId(deviceItemId);
        rec.setCheckedAt(LocalDateTime.now());

        var empOpt = employeeRepo.findById(employeeId);
        var devOpt = deviceRepo.findById(deviceItemId);

        // Employee or device not found
        if (empOpt.isEmpty() || devOpt.isEmpty()) {
            rec.setIsEligible(false);
            rec.setReason("Employee or device not found");
            return eligibilityRepo.save(rec);
        }

        EmployeeProfile emp = empOpt.get();
        DeviceCatalogItem dev = devOpt.get();

        // Inactive employee
        if (!Boolean.TRUE.equals(emp.getActive())) {
            rec.setIsEligible(false);
            rec.setReason("Employee not active");
            return eligibilityRepo.save(rec);
        }

        // Inactive device
        if (!Boolean.TRUE.equals(dev.getActive())) {
            rec.setIsEligible(false);
            rec.setReason("Device inactive");
            return eligibilityRepo.save(rec);
        }

        // Already has active issuance for this device
        if (!issuedRepo.findActiveByEmployeeAndDevice(employeeId, deviceItemId).isEmpty()) {
            rec.setIsEligible(false);
            rec.setReason("Active issuance already exists");
            return eligibilityRepo.save(rec);
        }

        long totalActive = issuedRepo.countActiveDevicesForEmployee(employeeId);

        // Check device-level max (primitive int, no null comparison)
        int devMax = dev.getMaxAllowedPerEmployee();
        if (totalActive >= devMax) {
            rec.setIsEligible(false);
            rec.setReason("Maximum allowed devices reached");
            return eligibilityRepo.save(rec);
        }

        // Check policy rules
        List<PolicyRule> rules = policyRepo.findByActiveTrue();
        for (PolicyRule rule : rules) {
            boolean deptMatch = rule.getAppliesToDepartment() == null
                    || rule.getAppliesToDepartment().equals(emp.getDepartment());
            boolean roleMatch = rule.getAppliesToRole() == null
                    || rule.getAppliesToRole().equals(emp.getJobRole());

            int ruleMax = rule.getMaxDevicesAllowed(); // primitive int
            if (deptMatch && roleMatch && totalActive >= ruleMax) {
                rec.setIsEligible(false);
                rec.setReason("Policy violation");
                return eligibilityRepo.save(rec);
            }
        }

        // Eligible
        rec.setIsEligible(true);
        rec.setReason("Eligible");
        return eligibilityRepo.save(rec);
    }
}
