package com.insureflow.insureflow.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "policies")
@Data
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String coverageType; // E.g., "Health", "Life", "Auto"
    private Double premium;      // Monthly premium
    private LocalDate renewalDate; // Next renewal date
}