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

import javax.servlet.http.HttpSession;
import java.util.Date;

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

    @GetMapping("/lease/{id}")
    public String createLease(@PathVariable("id") String registrationNumber, Model model, HttpSession session) {
        Car car = carService.getCarById(registrationNumber);
        if(car.getStatus().equals("reserved")) model.addAttribute("lease", leaseService.findLease(registrationNumber));
        model.addAttribute("car", car);
        String errorMessage = (String) session.getAttribute("errorMessage");
        if(errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            session.removeAttribute("errorMessage");
        }
        return "create-lease";
    }

    @PostMapping("/update-lease")
    public String updateCustomer(@RequestParam("updateCprNumber") String cprNumber,
                                 @RequestParam("updateCarRegNumber") String regNumber,
                                 @RequestParam("updateStartDate") String startDate,
                                 @RequestParam("updateEndDate") String endDate,
                                 @RequestParam("updatePrice") int price,
                                 @RequestParam("updateCustomerAccountNumber") String customerAccountNumber,
                                 @RequestParam("updateCustomerRegNumber") String customerRegNumber){
        leaseService.updateLease(new Lease(price,startDate,endDate,regNumber,cprNumber,customerAccountNumber,customerRegNumber));

        return "redirect:/landingpage";
    }


    // TODO: 13-05-2022 lige nu mangler den at tage højde for om customer cpr er registreret. Den kan godt oprette leasing kontrakt uden at et cpr nummer findes
    @PostMapping("/create-lease")
    public String createLease(@RequestParam("cprNumber") String cprNumber,
                                 @RequestParam("regNumber") String regNumber,
                                 @RequestParam("price") int price,
                                 @RequestParam("customerAccountNumber") String customerAccountNumber,
                                 @RequestParam("customerRegNumber") String customerRegNumber,
                                 @RequestParam("startDate") String startDate,
                                 @RequestParam("endDate") String endDate,
                                 HttpSession session){
        Lease lease = new Lease(price,startDate, endDate, regNumber,cprNumber,customerAccountNumber,customerRegNumber);
        if(customerService.findUserByCPR(cprNumber) == null){
            session.setAttribute("errorMessage","Kunde med dette cpr-nummer findes ikke");
            return "redirect:/lease/" + regNumber;
        }
        boolean leasingAgreement = leaseService.addLease(lease);
        if (leasingAgreement) carService.updateStatus(regNumber);

        return "redirect:/landingpage";
    }



}
