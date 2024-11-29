package com.insureflow.insureflow.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Each account is associated with one user
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Account type cannot be null")
    private String accountType; // E.g., "Savings", "Checking"
    @Min(value = 0, message = "Balance must be positive")
    private Double balance;     // Current balance
}
