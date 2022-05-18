package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.services.DamageReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

public class DamageReportController {

    private DamageReportService damageReportService;

    public DamageReportController(DamageReportService damageReportService) {
        this.damageReportService = damageReportService;
    }

    @GetMapping("/show-damagereport/{id}")
    public String showDamageReport(@PathVariable("id") String chassisNumber, Model model) { /*Skal det være registrationNumber siden at det er bilend ID?*/
        List<DamageReport> damageReports = damageReportService.showAllDamageReportsByChassisNumber(chassisNumber);
        model.addAttribute("selectedDamageReport", damageReports);

        return "show-damagereport";
    }
}
