// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class DeviceCatalogItem {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String deviceCode;

//     private String deviceType;
//     private String model;
//     private Integer maxAllowedPerEmployee;
//     private Boolean active;

  
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getDeviceCode() {
//         return deviceCode;
//     }

//     public void setDeviceCode(String deviceCode) {
//         this.deviceCode = deviceCode;
//     }

//     public String getDeviceType() {
//         return deviceType;
//     }

//     public void setDeviceType(String deviceType) {
//         this.deviceType = deviceType;
//     }

//     public String getModel() {
//         return model;
//     }

//     public void setModel(String model) {
//         this.model = model;
//     }

//     public Integer getMaxAllowedPerEmployee() {
//         return maxAllowedPerEmployee;
//     }

//     public void setMaxAllowedPerEmployee(Integer maxAllowedPerEmployee) {
//         this.maxAllowedPerEmployee = maxAllowedPerEmployee;
//     }

//     public Boolean getActive() {
//         return active;
//     }

//     public void setActive(Boolean active) {
//         this.active = active;
//     }
// }

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "device_catalog_item")
public class DeviceCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // example fields
    private String name;
    private String description;

    // ✅ REQUIRED
    public DeviceCatalogItem() {
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
