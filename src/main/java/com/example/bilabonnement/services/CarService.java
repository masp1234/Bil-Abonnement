package com.example.bilabonnement.services;

import com.example.bilabonnement.repositories.CarRepository;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    private CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
