// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;
// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;
// // @Getter
// // @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// // @Entity
// @Entity
// @Table(name = "eligibility_check_records")
// @Getter
// @Setter
// public class EligibilityCheckRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long employeeId;
//     private Long deviceItemId;
//     private boolean eligible;

// // }
// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// @Entity
// @Getter @Setter
// @NoArgsConstructor @AllArgsConstructor
// public class EligibilityCheckRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "eligibility_check")
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private Long deviceItemId;

    @Column(nullable = false)
    private boolean isEligible;

    @Column(nullable = false)
    private String reason;

    // ✅ REQUIRED: No-args constructor
    public EligibilityCheckRecord() {
    }

    // ✅ Getters & Setters

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDeviceItemId() {
        return deviceItemId;
    }

    public void setDeviceItemId(Long deviceItemId) {
        this.deviceItemId = deviceItemId;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setIsEligible(boolean eligible) {
        isEligible = eligible;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
