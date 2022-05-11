package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Lease;
import com.example.bilabonnement.repositories.LeaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaseService {

    private LeaseRepository leaseRepository;

    public LeaseService(LeaseRepository leaseRepository) {
        this.leaseRepository = leaseRepository;
    }

    public void addLease(Lease lease) {
        leaseRepository.addLease(lease);
    }

}
