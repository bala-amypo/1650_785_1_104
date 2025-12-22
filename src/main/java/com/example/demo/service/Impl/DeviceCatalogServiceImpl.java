package com.example.demo.service.Impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    private final DeviceCatalogItemRepository repository;

    public DeviceCatalogItemServiceImpl(DeviceCatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceCatalogItem createDevice(DeviceCatalogItem item) {

        // ✅ ONLY REQUIRED VALIDATION
        if (item.getMaxAllowedDevices() < 1) {
            throw new BadRequestException("Max devices allowed must be >= 1");
        }

        return repository.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceCatalogItem getDeviceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Device not found"));
    }

    @Override
    public void deleteDevice(Long id) {
        repository.deleteById(id);
    }
}
