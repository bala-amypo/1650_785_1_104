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

    public DeviceCatalogItem getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<DeviceCatalogItem> getAll() {
        return repo.findAll();
    }

    public DeviceCatalogItem update(Long id, DeviceCatalogItem item) {
        DeviceCatalogItem existing = getById(id);
        if (existing != null) {
            existing.setDeviceCode(item.getDeviceCode());
            existing.setDeviceType(item.getDeviceType());
            existing.setModel(item.getModel());
            existing.setMaxAllowedPerEmployee(item.getMaxAllowedPerEmployee());
            existing.setActive(item.getActive());
            return repo.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}