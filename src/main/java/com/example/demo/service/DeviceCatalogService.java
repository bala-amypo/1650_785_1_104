package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DeviceCatalogItem;


public interface DeviceCatalogService {
    DeviceCatalogItem save(DeviceCatalogItem d);
    List<DeviceCatalogItem> findAll();
}