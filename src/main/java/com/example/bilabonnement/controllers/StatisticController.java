package com.example.bilabonnement.controllers;


import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.services.CarStatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatisticController {

    private CarStatisticService carStatisticService;


    // TODO ryd op i denne controller
    public StatisticController(CarStatisticService CarStatisticService) {
        this.carStatisticService = CarStatisticService;

    }
    @GetMapping("/statistics")
    public String getStatistics(Model model) {
        List<CarMakeStatistic> carMakeStatistics = carStatisticService.getCarMakeStatistics();
        model.addAttribute("carMakeStatistics", carMakeStatistics);

        return "statistics";
    }

}
