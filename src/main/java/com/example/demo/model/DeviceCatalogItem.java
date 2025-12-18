package com.example.demo.model;
import jakarta.persistence.*;

@Entity
public class DeviceCatalogItem{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String deviceCode;
    private String deviceType;
    private String model;
    private Integer maxAllowedPerEmployee;
    private Boolean active=true;
    public DeviceCatalogItem(){

    }
    public DeviceCatalogItem(Long id,
    @Column(unique=true)
     String deviceCode,
     String deviceType,
     String model,
     Integer maxAllowedPerEmployee,
     Boolean active){

     }
}