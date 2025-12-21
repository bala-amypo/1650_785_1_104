package com.example.demo.model;
import Lombok.*;

import jakarta.persistence.*;
@Entity
@Table(name = "issued_device_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long employeeId;

    @NotNull
    @Column(nullable = false)
    private Long deviceItemId;

    @NotNull
    @Column(nullable = false)
    private LocalDate issuedDate;

    private LocalDate returnedDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;

    @PrePersist
    @PreUpdate
    void updateStatus() {
        this.status = (returnedDate == null)
                ? DeviceStatus.ISSUED
                : DeviceStatus.RETURNED;
    }
}

