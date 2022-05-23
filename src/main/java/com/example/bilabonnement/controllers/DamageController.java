package com.example.bilabonnement.controllers;


import com.example.bilabonnement.models.Damage;
import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.services.DamageReportService;
import com.example.bilabonnement.services.DamageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class DamageController {


    private DamageService damageService;
    private DamageReportService damageReportService;

    public DamageController(DamageService damageService, DamageReportService damageReportService) {
        this.damageService = damageService;
        this.damageReportService = damageReportService;
    }


    @GetMapping("/damages/{id}")
    public String getAllDamages(@PathVariable("id") int id, Model model, HttpSession session){
        DamageReport damageReport = damageReportService.getDamageReportsById(id);
        model.addAttribute("damageReport", damageReport);
        session.setAttribute("damageReportId", id);
        ArrayList<Damage> damageList= (ArrayList<Damage>) damageService.getAllDamages(id);
        model.addAttribute("damages", damageList);
        return "show-damages";
    }

    @GetMapping("/add-damage")
    public String addDamageForm(){
        return "add-damage(skal sletes senere)";
    }

    @PostMapping("add-damage")
    public String addDamage(@RequestParam("description") String description,
                            @RequestParam("price") int price,HttpSession session){
        int damageReportId= (int) session.getAttribute("damageReportId");
        damageService.addDamage(new Damage(description, price, damageReportId));
        return "redirect:/damages/" + damageReportId;
    }

    @GetMapping("delete-damage/{id}")
    public String deleteDamageById(@PathVariable("id") int id, HttpSession session){
        damageService.deleteById(id);
        return "redirect:/damages/" + session.getAttribute("damageReportId");
    }



}
