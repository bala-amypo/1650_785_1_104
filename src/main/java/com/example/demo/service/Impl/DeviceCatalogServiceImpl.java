// package com.example.demo.service.Impl;

// import com.example.demo.model.DeviceCatalogItem;
// import com.example.demo.repository.DeviceCatalogItemRepository;
// import com.example.demo.service.DeviceCatalogService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class DeviceCatalogServiceImpl implements DeviceCatalogService {

//     private final DeviceCatalogItemRepository repository;

//     public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public DeviceCatalogItem createDevice(DeviceCatalogItem item) {
//         // Optional simple check
//         if (item.getMaxAllowedPerEmployee() < 1) {
//             item.setMaxAllowedPerEmployee(1);
//         }
//         return repository.save(item);
//     }

//     @Override
//     public List<DeviceCatalogItem> getAllDevices() {
//         return repository.findAll();
//     }

//     @Override
//     public DeviceCatalogItem getDeviceById(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     @Override
//     public void deleteDevice(Long id) {
//         repository.deleteById(id);
//     }
// }
////
package com.example.demo.service.impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogItemService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    private final DeviceCatalogItemRepository repository;

    public DeviceCatalogItemServiceImpl(DeviceCatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceCatalogItem create(DeviceCatalogItem item) {
        if (repository.existsByDeviceCode(item.getDeviceCode())) {
            throw new BadRequestException("Device code already exists");
        }
        return repository.save(item);
    }

    @Override
    public DeviceCatalogItem getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));
    }

    @Override
    public List<DeviceCatalogItem> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}