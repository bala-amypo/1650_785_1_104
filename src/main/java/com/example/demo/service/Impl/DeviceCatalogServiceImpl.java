package com.example.demo.service.Impl;

import com.example.demo.entity.DeviceCatalog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.DeviceCatalogRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogRepository deviceCatalogRepository;

    public DeviceCatalogServiceImpl(DeviceCatalogRepository deviceCatalogRepository) {
        this.deviceCatalogRepository = deviceCatalogRepository;
    }

    @Override
    public DeviceCatalog createDevice(DeviceCatalog deviceCatalog) {

        if (deviceCatalog.getDeviceName() == null || deviceCatalog.getDeviceName().isBlank()) {
            throw new BadRequestException("Device name must not be empty");
        }

        if (deviceCatalog.getDeviceType() == null || deviceCatalog.getDeviceType().isBlank()) {
            throw new BadRequestException("Device type must not be empty");
        }

        if (deviceCatalog.getMaxAllowedDevices() < 1) {
            throw new BadRequestException("Max devices allowed must be >= 1");
        }

        return deviceCatalogRepository.save(deviceCatalog);
    }

    @Override
    public List<DeviceCatalog> getAllDevices() {
        return deviceCatalogRepository.findAll();
    }

    @Override
    public DeviceCatalog getDeviceById(Long id) {
        return deviceCatalogRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Device not found"));
    }

    @Override
    public void deleteDevice(Long id) {
        deviceCatalogRepository.deleteById(id);
    }
}
