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
    @GetMapping("/add-customer")
    public String addCustomer(){
        return "create-customer";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,
                         @RequestParam("zipCode") int zipCode,
                         @RequestParam("city") String city,
                         @RequestParam("phoneNumber") int phoneNumber,
                         @RequestParam("cpr") int cpr,
                         @RequestParam("accountNumber") int accountNumber,
                         @RequestParam("registrationNumber") int registrationNumber){
        Customer customer = new Customer(cpr,accountNumber,registrationNumber,firstName,lastName,email,phoneNumber,address,zipCode,city);

        customerService.addCustomer(customer);
        return "dataregister-landingpage";
    }



}
