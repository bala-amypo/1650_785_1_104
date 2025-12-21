package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repo;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repo) {
        this.repo = repo;
    }

    public DeviceCatalogItem create(DeviceCatalogItem item) {
        return repo.save(item);
    }

    public DeviceCatalogItem updateActive(Long id, Boolean active) {
        DeviceCatalogItem item = repo.findById(id).orElse(null);
        if (item != null) {
            item.setActive(active);
            return repo.save(item);
        }
        return null;
    }

    public List<DeviceCatalogItem> getAll() {
        return repo.findAll();
    }
}