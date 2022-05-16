package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class DamageReportController {

    private CarService carService;

    public DamageReportController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/show-damagereport/{id}")
    public String showDamageReport(@PathVariable("id") String registrationNumber) { /*Skal det være registrationNumber siden at det er bilend ID?*/
        Car car = carService.getCarById(registrationNumber);
        return "show-damagereport";
    }
}
