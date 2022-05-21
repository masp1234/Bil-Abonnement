package com.example.bilabonnement.controllers;


import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.repositories.CarStatisticRepository;
import com.example.bilabonnement.services.CarStatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatisticController {

    private CarStatisticService carStatisticService;
    private CarStatisticRepository carStatisticRepository;

    // TODO ryd op i denne controller
    public StatisticController(CarStatisticService CarStatisticService, CarStatisticRepository carStatisticRepository) {
        this.carStatisticService = CarStatisticService;
        this.carStatisticRepository = carStatisticRepository;
    }
    @GetMapping("/statistics")
    public String getStatistics(Model model) {
        List<CarMakeStatistic> carMakeStatistics = carStatisticService.getCarMakeStatistics();
        model.addAttribute("carMakeStatistics", carMakeStatistics);

        return "statistics";
    }

    @GetMapping("test")
    public String test() {
        List<Double> averageLeasePeriodsPerCarMake = carStatisticRepository.getAverageLeasePeriodsPerCarMake();
        System.out.println(averageLeasePeriodsPerCarMake);
        List<Double> averagePricePerMonth = carStatisticRepository.getAverageLeasePricePerMonthPerCarMake();
        System.out.println(averagePricePerMonth);

        return "index";
    }

    @GetMapping("test2")
    public String test2() {
        carStatisticRepository.getCarMakesAndStatus();

        return "index";
    }
}
