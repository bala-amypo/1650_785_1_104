package com.example.demo.model;
// import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
// import Lombok.setter
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(
    name = "device_catalog_items",
    uniqueConstraints = @UniqueConstraint(columnNames = "device_code")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "device_code", nullable = false, unique = true)
    private String deviceCode;

    @NotBlank
    @Column(nullable = false)
    private String deviceType;

    @NotBlank
    @Column(nullable = false)
    private String model;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer maxAllowedPerEmployee;

    @NotNull
    @Column(nullable = false)
    private Boolean active;

   
    
}