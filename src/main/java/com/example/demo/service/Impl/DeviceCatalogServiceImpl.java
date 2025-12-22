package com.example.demo.service.Impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repository;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceCatalogItem createDevice(DeviceCatalogItem item) {
        // Optional simple check
        if (item.getMaxAllowedPerEmployee() < 1) {
            item.setMaxAllowedPerEmployee(1);
        }
        return repository.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceCatalogItem getDeviceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteDevice(Long id) {
        repository.deleteById(id);
    }
}
