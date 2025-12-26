package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
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

        if (empOpt.isEmpty() || devOpt.isEmpty()) {
            rec.setIsEligible(false);
            rec.setReason("Employee or device not found");
            return eligibilityRepo.save(rec);
        }

        EmployeeProfile emp = empOpt.get();
        DeviceCatalogItem dev = devOpt.get();

        if (!Boolean.TRUE.equals(emp.getActive())) {
            rec.setIsEligible(false);
            rec.setReason("Employee not active");
            return eligibilityRepo.save(rec);
        }

        if (!Boolean.TRUE.equals(dev.getActive())) {
            rec.setIsEligible(false);
            rec.setReason("Device inactive");
            return eligibilityRepo.save(rec);
        }

        if (!issuedRepo.findActiveByEmployeeAndDevice(employeeId, deviceItemId).isEmpty()) {
            rec.setIsEligible(false);
            rec.setReason("Active issuance already exists");
            return eligibilityRepo.save(rec);
        }

        long totalActive = issuedRepo.countActiveDevicesForEmployee(employeeId);
        if (dev.getMaxAllowedPerEmployee() != null &&
            totalActive >= dev.getMaxAllowedPerEmployee()) {
            rec.setIsEligible(false);
            rec.setReason("Maximum allowed devices reached");
            return eligibilityRepo.save(rec);
        }

        List<PolicyRule> rules = policyRepo.findByActiveTrue();
        for (PolicyRule rule : rules) {
            boolean deptMatch = rule.getAppliesToDepartment() == null ||
                                rule.getAppliesToDepartment().equals(emp.getDepartment());
            boolean roleMatch = rule.getAppliesToRole() == null ||
                                rule.getAppliesToRole().equals(emp.getJobRole());
            if (deptMatch && roleMatch && rule.getMaxDevicesAllowed() != null &&
                totalActive >= rule.getMaxDevicesAllowed()) {
                rec.setIsEligible(false);
                rec.setReason("Policy violation");
                return eligibilityRepo.save(rec);
            }
        }

        rec.setIsEligible(true);
        rec.setReason("Eligible");
        return eligibilityRepo.save(rec);
    }
}
