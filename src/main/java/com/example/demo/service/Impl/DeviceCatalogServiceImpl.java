package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.DeviceCatalogRepository;
import com.example.demo.model.DeviceCatalog;
import com.example.demo.service.DeviceCatalogService;

public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogRepository repo;

    public DeviceCatalogServiceImpl(DeviceCatalogRepository repo) {
        this.repo = repo;
    }

    public DeviceCatalog save(DeviceCatalog d) {
        return repo.save(d);
    }

    public List<DeviceCatalog> findAll() {
        return repo.findAll();
    }
}
