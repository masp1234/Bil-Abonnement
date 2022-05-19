package com.example.bilabonnement.controllers;


import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.services.StatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticController {

    private StatisticService statisticService;

    public StatisticController(StatisticService statisticService){
        this.statisticService = statisticService;
    }

    @GetMapping("show-statistics")
    public String showStatistics(Model model){
        model.addAttribute("carStatistics",statisticService.getCarStatistics());
        model.addAttribute("carNamesStatistics",statisticService.getCarNamesStatistics());
        return "statistics";
    }
}
