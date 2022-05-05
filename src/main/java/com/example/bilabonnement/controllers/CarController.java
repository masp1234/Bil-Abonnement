package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarController {



    private CarService carService;

    public CarController (CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/update-car/{id}")
    public String showUpdateCar(@PathVariable("id") int id) {
        Car car = carService.getCarById(id);

        return "update-car";
    }
}
