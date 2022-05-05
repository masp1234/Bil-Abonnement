package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CarController {



    private CarService carService;

    public CarController (CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/update-car/{id}")
    public String showUpdateCar(@PathVariable("id") int id, Model model) {
        Car car = carService.getCarById(id);

        model.addAttribute("selectedCar", car);

        //TODO midlertidig template
        return "update-car";
    }

    @PostMapping("/update-car")
    public String updateCar(@ModelAttribute Car car, HttpSession session) {
        carService.updateCar(car);


        //TODO Skal ændres når rigtige template er klar og der er ikke nogen session atm
        return "redirect:/update-car" + session.getAttribute("carId");
    }
}
