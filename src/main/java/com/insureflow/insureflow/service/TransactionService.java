package com.insureflow.insureflow.service;

import com.insureflow.insureflow.model.Transaction;
import com.insureflow.insureflow.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}