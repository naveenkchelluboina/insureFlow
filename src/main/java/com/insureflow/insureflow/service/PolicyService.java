package com.insureflow.insureflow.service;

import com.insureflow.insureflow.model.Policy;
import com.insureflow.insureflow.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public List<Policy> getPoliciesByUserId(Long userId) {
        return policyRepository.findByUserId(userId);
    }

    public Policy getPolicyById(Long policyId) {
        return policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy with ID " + policyId + " not found"));
    }
}
