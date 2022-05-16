package com.example.bilabonnement.controllers;


import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.models.Lease;
import com.example.bilabonnement.services.CarService;
import com.example.bilabonnement.services.CustomerService;
import com.example.bilabonnement.services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LeaseController {

    private CustomerService customerService;
    private CarService carService;
    private LeaseService leaseService;

    public LeaseController (CustomerService customerService, CarService carService, LeaseService leaseService) {
        this.customerService = customerService;
        this.carService = carService;
        this.leaseService = leaseService;
    }


    //TODO skal måske modtage kundeId som parameter
    @GetMapping("/create-lease/{id}")
    public String showCreateLease(@PathVariable("id") String registrationNumber, Model model) {
        Car car = carService.getCarById(registrationNumber);
        model.addAttribute("car", car);
        return "create-lease";
    }


    // TODO: 13-05-2022 lige nu mangler den at tage højde for om customer cpr er registreret. Den kan godt oprette leasing kontrakt uden at et cpr nummer findes
    @PostMapping("/create-lease")
    public String createlease(@RequestParam("cprNumber") String cprNumber,
                              @RequestParam("regNumber") String regNumber,
                              @RequestParam("period") int period,
                              @RequestParam("price") int price,
                              @RequestParam("customerAccountNumber") String customerAccountNumber,
                              @RequestParam("customerRegNumber") String customerRegNumber){
        Lease lease = new Lease(price,period,regNumber,cprNumber,customerAccountNumber,customerRegNumber);
        if(customerService.findUserByCPR(cprNumber) == null){
            return "/create-lease/" + regNumber;
        }
        boolean leasingAgreement = leaseService.addLease(lease);
        if (leasingAgreement) carService.updateStatus(regNumber);
        return "redirect:/landingpage";
    }



}
