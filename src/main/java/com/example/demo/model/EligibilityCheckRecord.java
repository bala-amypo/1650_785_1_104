package com.example.demo.model;
// import Lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "eligibility_check_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EligibilityCheckRecord {

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
    private Boolean isEligible;

    @NotBlank
    @Column(nullable = false)
    private String reason;

    @NotNull
    @Column(nullable = false, updatable = false)
    private LocalDateTime checkedAt;

    @PrePersist
    void onCheck() {
        this.checkedAt = LocalDateTime.now();
    }
}
