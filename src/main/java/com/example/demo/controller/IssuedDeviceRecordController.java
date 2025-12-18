package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;

@RestController
@RequestMapping("/api/issued-devices")
public class IssuedDeviceRecordController {

    private final IssuedDeviceRecordService service;

    public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<IssuedDeviceRecord> issue(@RequestBody IssuedDeviceRecord record) {
        return ResponseEntity.ok(service.issueDevice(record));
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<IssuedDeviceRecord> returnDevice(@PathVariable Long id) {
        return ResponseEntity.ok(service.returnDevice(id));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<IssuedDeviceRecord>> getByEmployee(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(service.getIssuedDevicesByEmployee(employeeId));
    }
}
