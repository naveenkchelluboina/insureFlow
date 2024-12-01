package com.insureflow.insureflow.controller;

import com.insureflow.insureflow.model.Account;
import com.insureflow.insureflow.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping
    public List<Account> getAccounts(@RequestParam(required = false) Long userId) {
        if (userId != null) {
            // Fetch accounts for a specific user
            return accountService.getAccountsByUserId(userId);
        }
        // Fetch all accounts if no userId is provided
        return accountService.getAllAccounts();
    }
}
