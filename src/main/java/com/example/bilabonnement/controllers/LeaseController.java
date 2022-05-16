package com.example.bilabonnement.controllers;


import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Lease;
import com.example.bilabonnement.services.CarService;
import com.example.bilabonnement.services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LeaseController {

    private CarService carService;
    private LeaseService leaseService;

    public LeaseController (CarService carService, LeaseService leaseService) {
        this.carService = carService;
        this.leaseService = leaseService;
    }


    //TODO skal måske modtage kundeId som parameter
    @GetMapping("/create-lease/{id}")
    public String createLease(@PathVariable("id") String registrationNumber, Model model) {
        Car car = carService.getCarById(registrationNumber);
        model.addAttribute("car", car);


        return "create-lease";
    }

    // TODO: 13-05-2022 lige nu mangler den at tage højde for om customer cpr er registreret. Den kan godt oprette leasing kontrakt uden at et cpr nummer findes
    @PostMapping("/create-lease")
    public String createCustomer(@RequestParam("cprNumber") String cprNumber,
                                 @RequestParam("regNumber") String regNumber,
                                 @RequestParam("period") int period,
                                 @RequestParam("price") int price){
        Lease lease = new Lease(price,period,regNumber,cprNumber);
        boolean leasingAgreement = leaseService.addLease(lease);
        if (leasingAgreement) carService.updateStatus(regNumber,"reserved");
        return "redirect:/landingpage";
    }



}
