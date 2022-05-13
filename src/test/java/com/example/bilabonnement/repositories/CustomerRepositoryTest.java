package com.example.bilabonnement.repositories;


import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository testRepository;

    @Test
    void getCarById() {
        // arrange
        Customer customer = new Customer("23452345","4234","2231","Daniel", "danielsen", "asdf@mail.com", 234234, "blåbærsvej 80", 2670,"københavn");

        testRepository.addCustomer(customer);



    }
}