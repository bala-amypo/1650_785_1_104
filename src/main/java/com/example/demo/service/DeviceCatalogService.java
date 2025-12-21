package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;
import java.util.List;
public interface DeviceCatalogService {
    DeviceCatalogItem create(DeviceCatalogItem d);
    List<DeviceCatalogItem> getAll();
}