package com.insureflow.insureflow.controller;

import com.insureflow.insureflow.model.Policy;
import com.insureflow.insureflow.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    @GetMapping
    public List<Policy> getPolicies(@RequestParam(required = false) Long userId) {
        if (userId != null) {
            // Fetch policies for a specific user
            return policyService.getPoliciesByUserId(userId);
        }
        // Fetch all policies if no userId is provided
        return policyService.getAllPolicies();
    }

    @PostMapping("/{policyId}/risk-assessment")
    public int assessRisk(@PathVariable Long policyId) {
        Policy policy = policyService.getPolicyById(policyId);
        return calculateRiskScore(policy);
    }

    private int calculateRiskScore(Policy policy) {
        int riskScore = 0;

        // Example: Higher premium → Higher risk
        if (policy.getPremium() > 500) riskScore += 50;

        // Example: Close to renewal date → Higher risk
        if (policy.getRenewalDate().isBefore(LocalDate.now().plusMonths(1))) riskScore += 30;

        return riskScore;
    }
}
