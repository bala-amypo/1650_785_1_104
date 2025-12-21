package com.example.demo.model;
import Lombok.*;

import jakarta.persistence.*;
@Entity
@Table(
    name = "policy_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = "rule_code")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "rule_code", nullable = false, unique = true)
    private String ruleCode;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String appliesToRole;

    @NotBlank
    @Column(nullable = false)
    private String appliesToDepartment;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer maxDevicesAllowed;

    @NotNull
    @Column(nullable = false)
    private Boolean active;
}