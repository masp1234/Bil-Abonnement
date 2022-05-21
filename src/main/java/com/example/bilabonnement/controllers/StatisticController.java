package com.example.bilabonnement.controllers;


import com.example.bilabonnement.repositories.CarStatisticRepository;
import com.example.bilabonnement.services.CarStatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatisticController {

    private CarStatisticService statisticService;
    private CarStatisticRepository carStatisticRepository;

    public StatisticController(CarStatisticService statisticService, CarStatisticRepository carStatisticRepository) {
        this.statisticService = statisticService;
        this.carStatisticRepository = carStatisticRepository;
    }

    @GetMapping("test")
    public String test() {
        List<Double> averageLeasePeriodsPerCarMake = carStatisticRepository.getAverageLeasePeriodsPerCarMake();
        System.out.println(averageLeasePeriodsPerCarMake);
        List<Double> averagePricePerMonth = carStatisticRepository.getAverageLeasePricePerMonthPerCarMake();
        System.out.println(averagePricePerMonth);

        return "index";
    }
}
