package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityCheckService;

public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EmployeeProfileRepository empRepo;
    private final DeviceCatalogItemRepository devRepo;
    private final IssuedDeviceRecordRepository issuedRepo;
    private final PolicyRuleRepository policyRepo;
    private final EligibilityCheckRecordRepository checkRepo;

    public EligibilityCheckServiceImpl(
            EmployeeProfileRepository empRepo,
            DeviceCatalogItemRepository devRepo,
            IssuedDeviceRecordRepository issuedRepo,
            PolicyRuleRepository policyRepo,
            EligibilityCheckRecordRepository checkRepo) {

        this.empRepo = empRepo;
        this.devRepo = devRepo;
        this.issuedRepo = issuedRepo;
        this.policyRepo = policyRepo;
        this.checkRepo = checkRepo;
    }

    public EligibilityCheckRecord validateEligibility(Long empId, Long devId) {

        EmployeeProfile emp = empRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        if (!emp.getActive()) throw new BadRequestException("not active");

        DeviceCatalogItem dev = devRepo.findById(devId)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        if (!dev.getActive()) throw new BadRequestException("inactive");

        if (!issuedRepo.findActiveByEmployeeAndDevice(empId, devId).isEmpty())
            throw new BadRequestException("active issuance");

        if (issuedRepo.countActiveDevicesForEmployee(empId)
                >= dev.getMaxAllowedPerEmployee())
            throw new BadRequestException("Maximum allowed devices");

        EligibilityCheckRecord rec = new EligibilityCheckRecord();
        rec.setEmployeeId(empId);
        rec.setDeviceItemId(devId);
        rec.setIsEligible(true);
        rec.setReason("Eligible");

        return checkRepo.save(rec);
    }

    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return checkRepo.findByEmployeeId(employeeId);
    }
}

