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

    @GetMapping("/user/{userId}")
    public List<Policy> getPoliciesByUserId(@PathVariable Long userId) {
        return policyService.getPoliciesByUserId(userId);
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
