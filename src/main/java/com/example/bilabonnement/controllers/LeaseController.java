package com.example.bilabonnement.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaseController {


    //TODO skal måske modtage kundeId som parameter
    @GetMapping("/create-lease")
    public String createLease() {



        return "create-lease";
    }


}
