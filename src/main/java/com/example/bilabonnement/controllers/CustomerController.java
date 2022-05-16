package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("/create-customer")
    public String addCustomer(){
        return "create-customer";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,
                         @RequestParam("zipCode") int zipCode,
                         @RequestParam("phoneNumber") int phoneNumber,
                         @RequestParam("cpr") String cpr,
                         @RequestParam("accountNumber") String accountNumber,
                         @RequestParam("registrationNumber") String registrationNumber){
        Customer customer = new Customer();
        customer.setCpr(cpr);
        customer.setAccountNumber(accountNumber);
        customer.setRegistrationNumber(registrationNumber);
        customer.setFirstname(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setZipCode(zipCode);
        customer.setAddress(address);
        System.out.println(customer);

        customerService.addCustomer(customer);
        return "redirect:/landingpage";
    }



}
