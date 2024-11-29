package com.insureflow.insureflow.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    private Double amount; // Positive for deposit, negative for withdrawal
    private String type;   // "DEPOSIT" or "WITHDRAWAL"
    private LocalDateTime timestamp;
}
