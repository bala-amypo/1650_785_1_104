package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository deviceRepo;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceCatalogItem createItem(DeviceCatalogItem item) {
        Integer max = item.getMaxAllowedPerEmployee();
        if (max == null || max <= 0) {
            throw new BadRequestException("maxAllowedPerEmployee must be > 0");
        }
        deviceRepo.findByDeviceCode(item.getDeviceCode()).ifPresent(d -> {
            throw new BadRequestException("Device code already exists");
        });
        return deviceRepo.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return deviceRepo.findAll();
    }

    @Override
    public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
        DeviceCatalogItem item = deviceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        item.setActive(active);
        return deviceRepo.save(item);
    }
}


// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.DeviceCatalogItem;
// import com.example.demo.repository.DeviceCatalogItemRepository;
// import com.example.demo.service.DeviceCatalogService;

// @Service
// public class DeviceCatalogServiceImpl implements DeviceCatalogService {

//     private final DeviceCatalogItemRepository repo;

//     public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public DeviceCatalogItem createItem(DeviceCatalogItem item) {

//         // ✅ Invalid max limit
//         if (item.getMaxAllowedPerEmployee() == null ||
//             item.getMaxAllowedPerEmployee() <= 0) {
//             throw new BadRequestException("maxAllowedPerEmployee");
//         }

//         // ✅ Duplicate device code
//         if (repo.findByDeviceCode(item.getDeviceCode()).isPresent()) {
//             throw new BadRequestException("Device code already exists");
//         }

//         // default active = true
//         if (item.getActive() == null) {
//             item.setActive(true);
//         }

//         return repo.save(item);
//     }

//     @Override
//     public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
//         DeviceCatalogItem item = repo.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Device not found"));

//         item.setActive(active);
//         return repo.save(item);
//     }

//     @Override
//     public List<DeviceCatalogItem> getAllItems() {
//         return repo.findAll();
//     }

//     @Override
//     public DeviceCatalogItem getItemById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Device not found"));
//     }

//     @Override
//     public void deleteItem(Long id) {
//         if (!repo.existsById(id)) {
//             throw new ResourceNotFoundException("Device not found");
//         }
//         repo.deleteById(id);
//     }
// }
