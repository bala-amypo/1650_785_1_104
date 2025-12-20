package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;

@RestController
@RequestMapping("/issued-devices")
public class IssuedDeviceRecordController {

    private final IssuedDeviceRecordService service;

    public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
        this.service = service;
    }

    @PostMapping
    public IssuedDeviceRecord save(@RequestBody IssuedDeviceRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<IssuedDeviceRecord> getAll() {
        return service.findAll();
    }
}