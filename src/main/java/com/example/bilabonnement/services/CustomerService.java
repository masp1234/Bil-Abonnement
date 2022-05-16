package com.example.bilabonnement.services;
import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public Customer findUserByCPR(String cprNumber) {
        return customerRepository.findUserByCPR(cprNumber);
    }
}
