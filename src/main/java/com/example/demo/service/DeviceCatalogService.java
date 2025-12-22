package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;
import java.util.List;
public interface DeviceCatalogService {
    DeviceCatalogItem create(DeviceCatalogItem item);
    DeviceCatalogItem updateActive(Long id, Boolean active);
    List<DeviceCatalogItem> getAll();
}