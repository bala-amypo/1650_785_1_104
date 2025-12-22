package com.example.demo.service.Impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repo;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceCatalogItem create(DeviceCatalogItem item) {
        if (item == null) {
            return null;
        }
        item.setActive(true);
        return repo.save(item);
    }

    @Override
    public DeviceCatalogItem update(Long id, DeviceCatalogItem item) {
        Optional<DeviceCatalogItem> optional = repo.findById(id);
        if (optional.isPresent()) {
            DeviceCatalogItem existing = optional.get();
            existing.setDeviceName(item.getDeviceName());
            existing.setDeviceType(item.getDeviceType());
            existing.setManufacturer(item.getManufacturer());
            existing.setPrice(item.getPrice());
            existing.setActive(item.getActive());
            return repo.save(existing);
        }
        return null;
    }

    @Override
    public DeviceCatalogItem getById(Long id) {
        Optional<DeviceCatalogItem> optional = repo.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<DeviceCatalogItem> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<DeviceCatalogItem> optional = repo.findById(id);
        optional.ifPresent(repo::delete);
    }
}
