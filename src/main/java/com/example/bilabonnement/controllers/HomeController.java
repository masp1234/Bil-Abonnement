package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.User;
import com.example.bilabonnement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {



    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }



    //åbning af index side
    @GetMapping("/")
    public String index(HttpSession session){

        User user = (User) session.getAttribute("user");

        if (user != null) {

           /* if(user.getPermission().equalsignorecase("dataregistrering")){
                return "redirect:/bruger-forside-dataregistrering";
            }
            else if(user.getPermission().equalsignorecase("Forretningsudviklere ")){
                return "redirect:/bruger-forside-Forretningsudviklere";
            }
            else {
                return "redirect:/bruger-forside-Skade";
            }*/
            //uden redirect henter den ikke ønskelister
            return "redirect:/landingpage";
        }

        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");

        return "redirect:/";
    }



    // TODO: 06-05-2022 Måske i en userController
    //Postmapping på login
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        User user = userService.login(username,password);

        if(user == null){
            return "redirect:/";
        }  else {
            session.setAttribute("user", user);
            if(user.getRole().equals("forretningsudvikler"))return "statistics";
            else return "redirect:/landingpage";


            }
        }



    }

