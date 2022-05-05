package com.example.bilabonnement.controllers;

import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;

@Controller
public class CarController {



    private CarService carService;

    public CarController (CarService carService) {
        this.carService = carService;
    }
}
