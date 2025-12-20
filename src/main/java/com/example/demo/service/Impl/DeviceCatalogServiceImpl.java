package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;
@Service

public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repo;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repo) {
        this.repo = repo;
    }

    public DeviceCatalogItem save(DeviceCatalogItem d) {
        return repo.save(d);
    }

    public List<DeviceCatalogItem> findAll() {
        return repo.findAll();
    }
}
