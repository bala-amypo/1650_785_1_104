package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.exception.*;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;

public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repo;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repo) {
        this.repo = repo;
    }

    public DeviceCatalogItem createItem(DeviceCatalogItem item) {

        if (item.getMaxAllowedPerEmployee() <= 0) {
            throw new BadRequestException("maxAllowedPerEmployee");
        }

        repo.findByDeviceCode(item.getDeviceCode())
                .ifPresent(d -> { throw new BadRequestException("exists"); });

        return repo.save(item);
    }

    public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
        DeviceCatalogItem item = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        item.setActive(active);
        return repo.save(item);
    }

    public List<DeviceCatalogItem> getAllItems() {
        return repo.findAll();
    }
}
