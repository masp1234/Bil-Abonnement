package com.example.bilabonnement.controllers;

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

    /*Daniel*/
    @GetMapping("/create-customer")
    public String addCustomer(){
        return "create-customer";
    }

    /*Daniel*/
    @PostMapping("/create-customer")
    public String createCustomer(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,
                         @RequestParam("zipCode") String zipCode,
                         @RequestParam("phoneNumber") String phoneNumber,
                         @RequestParam("cpr") String cpr){
        Customer customer = new Customer();
        customer.setCpr(cpr);
        customer.setFirstname(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setZipCode(zipCode);
        customer.setAddress(address);
        customerService.addCustomer(customer);
        return "redirect:/landingpage";
    }



}
