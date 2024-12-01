package com.insureflow.insureflow.controller;

import com.insureflow.insureflow.model.Transaction;
import com.insureflow.insureflow.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam(required = false) Long accountId) {
        if (accountId != null) {
            // Fetch transactions for a specific account
            return transactionService.getTransactionsByAccountId(accountId);
        }
        // Fetch all transactions if no accountId is provided
        return transactionService.getAllTransactions();
    }
}
