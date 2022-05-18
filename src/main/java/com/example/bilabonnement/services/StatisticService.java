package com.example.bilabonnement.services;

import com.example.bilabonnement.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StatisticService {

    private CarRepository carRepository;

    public StatisticService(CarRepository carRepository){
        this.carRepository = carRepository;
    }




}
