
// package com.example.demo.service.impl;

// import com.example.demo.model.DeviceCatalogItem;
// import com.example.demo.repository.DeviceCatalogItemRepository;
// import com.example.demo.service.DeviceCatalogService;
// import org.springframework.stereotype.Service;
// import com.example.demo.exception.ResourceNotFoundException;

// import java.util.List;

// @Service
// public class DeviceCatalogServiceImpl implements DeviceCatalogService {

//     private final DeviceCatalogItemRepository repository;

//     public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public DeviceCatalogItem create(DeviceCatalogItem item) {
//         return repository.save(item);
//     }

//     @Override
//     public DeviceCatalogItem getById(Long id) {
//         return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found"));
//     }

//     @Override
//     public List<DeviceCatalogItem> getAll() {
//         return repository.findAll();
//     }

//     @Override
//     public DeviceCatalogItem update(Long id, DeviceCatalogItem item) {
//         item.setId(id);
//         return repository.save(item);
//     }

//     @Override
//     public void delete(Long id) {
//         repository.deleteById(id);
//     }
// }
// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.DeviceCatalogItem;
// import com.example.demo.repository.DeviceCatalogItemRepository;
// import com.example.demo.service.DeviceCatalogService;
// import java.util.List;

// public class DeviceCatalogServiceImpl implements DeviceCatalogService {

//     private final DeviceCatalogItemRepository repo;

//     public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repo) {
//         this.repo = repo;
//     }

//     public DeviceCatalogItem createItem(DeviceCatalogItem item) {
//         if (item.getMaxAllowedPerEmployee() == null || item.getMaxAllowedPerEmployee() <= 0)
//             throw new BadRequestException("maxAllowedPerEmployee must be > 0");

//         repo.findByDeviceCode(item.getDeviceCode())
//                 .ifPresent(i -> { throw new BadRequestException("Device code exists"); });

//         return repo.save(item);
//     }

//     public List<DeviceCatalogItem> getAllItems() {
//         return repo.findAll();
//     }

//     public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
//         DeviceCatalogItem item = repo.findById(id)
//                 .orElseThrow(() -> new BadRequestException("Device not found"));
//         item.setActive(active);
//         return repo.save(item);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ THIS IS THE KEY FIX
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repository;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceCatalogItem create(DeviceCatalogItem item) {
        return repository.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAll() {
        return repository.findAll();
    }

    @Override
    public DeviceCatalogItem deactivate(Long id) {
        DeviceCatalogItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        item.setActive(false);
        return repository.save(item);
    }
}
