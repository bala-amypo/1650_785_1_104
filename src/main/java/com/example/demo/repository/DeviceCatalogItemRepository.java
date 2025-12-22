package com.example.demo.repository;

import com.example.demo.entity.DeviceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceCatalogRepository extends JpaRepository<DeviceCatalog, Long> {
}
