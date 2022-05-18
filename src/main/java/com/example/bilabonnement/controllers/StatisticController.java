package com.example.bilabonnement.controllers;


import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.services.StatisticService;
import org.springframework.stereotype.Controller;

@Controller
public class StatisticController {

    private StatisticService statisticService;

    public StatisticController(StatisticService statisticService){
        this.statisticService = statisticService;
    }
}
