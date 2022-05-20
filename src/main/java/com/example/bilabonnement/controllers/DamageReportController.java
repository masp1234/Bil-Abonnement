package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.services.DamageReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class DamageReportController {

    private DamageReportService damageReportService;


    public DamageReportController(DamageReportService damageReportService) {
        this.damageReportService = damageReportService;
    }

    @GetMapping("/show-damagereport/{chassisNumber}/{regNumber}")
    public String showDamageReport(@PathVariable("chassisNumber") String chassisNumber,
                                   @PathVariable("regNumber") String registrationNumber, Model model,
                                   HttpSession httpSession) { /*Skal det være registrationNumber siden at det er bilend ID?*/
        System.out.println(chassisNumber);
        List<DamageReport> damageReports = damageReportService.showAllDamageReportsByChassisNumber(chassisNumber);
        Car car = damageReportService.getCarById(registrationNumber);
        model.addAttribute("car", car);
        model.addAttribute("selectedDamageReport", damageReports);
        httpSession.setAttribute("registrationNumber", registrationNumber);

        return "show-damagereport";
    }

    @PostMapping("/create-damagereport")
    public String createDamagereport(
            @RequestParam("description") String description,
            @RequestParam("chassisNumber") String chassisNumber,
            HttpSession httpSession) {

        DamageReport damageReport = new DamageReport();
        damageReport.setDescription(description);
        damageReport.setChassisNumber(chassisNumber);
        System.out.println(damageReport);

        String registrationNumber = (String) httpSession.getAttribute("registrationNumber");
        damageReportService.addDamageReport(damageReport);
        return "redirect:/show-damagereport/"+chassisNumber + "/" + registrationNumber;
    }



}
