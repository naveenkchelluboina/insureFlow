package com.insureflow.insureflow.controller;

import com.insureflow.insureflow.model.Account;
import com.insureflow.insureflow.model.Policy;
import com.insureflow.insureflow.model.Transaction;
import com.insureflow.insureflow.model.User;
import com.insureflow.insureflow.repository.TransactionRepository;
import com.insureflow.insureflow.service.AccountService;
import com.insureflow.insureflow.service.PolicyService;
import com.insureflow.insureflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String email) {
        if (email != null) {
            // Fetch by email if provided
            User user = userService.findByEmail(email);
            return user != null ? List.of(user) : List.of(); // Return as a list
        }
        // Fetch all users if no email is provided
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}/dashboard")
    public Map<String, Object> getDashboardData(@PathVariable Long userId) {
        List<Account> accounts = accountService.getAccountsByUserId(userId);
        List<Policy> policies = policyService.getPoliciesByUserId(userId);
        List<Transaction> transactions = transactionRepository.findAll();

        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("totalAccounts", accounts.size());
        dashboard.put("totalPolicies", policies.size());
        dashboard.put("totalTransactions", transactions.size());

        return dashboard;
    }
}
