package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogItemService;

public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    private final DeviceCatalogItemRepository repo;

    public DeviceCatalogItemServiceImpl(DeviceCatalogItemRepository repo) {
        this.repo = repo;
    }

    public DeviceCatalogItem save(DeviceCatalogItem d) {
        return repo.save(d);
    }

    public List<DeviceCatalogItem> findAll() {
        return repo.findAll();
    }
}
