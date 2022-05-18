package com.example.bilabonnement.controllers;


import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Damage;
import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.services.DamageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class damageControllr {
    private DamageService damageService;

    public damageControllr(DamageService damageService) {
        this.damageService = damageService;
    }

    @GetMapping("/damages/{id}")
    public String getAllDamages(@PathVariable("id") int id, Model model, HttpSession session){
        Car car= (Car) session.getAttribute("Car");
        model.addAttribute("Car", car);
        session.setAttribute("damageReportId", id);
        List<Damage> damageList= damageService.getAllDamages(id);
        model.addAttribute("damageList", damageList);
        DamageReport damageReport= (DamageReport) damageService.getAllDamages(id);
        model.addAttribute("damageReportObject", damageReport );


        return "add-damage";
    }

    @GetMapping("/add-damage")
    public String addDamageForm(){
        return "add-damage";
    }

    @PostMapping("add-damage")
    public String addDamage(@RequestParam("description") String description,
                            @RequestParam("price") int price, HttpSession session){
        int damageReportId= (int) session.getAttribute("damageReportId");
        damageService.addDamage(new Damage(description, price, damageReportId));
        return "redirect:/damages/" + session.getAttribute("damageReportId");
    }

    @GetMapping("delete-damage/{id}")
    public String deletedamageById(@PathVariable("id") int id, HttpSession session){
        damageService.deleteById(id);
        return "redirect:/damages/" + session.getAttribute("damageReportId");
    }



}
