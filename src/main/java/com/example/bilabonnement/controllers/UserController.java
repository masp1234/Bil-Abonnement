package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.User;
import com.example.bilabonnement.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //åbning af index side

    /*Daniel*/
    @GetMapping("/")
    public String index(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (user.getRole().equalsIgnoreCase("forretningsudvikler")) {
                return "redirect:/statistics";
            }

            else {
                return "redirect:/landingpage";
                }
        }
        return "index";
        }

    /*Daniel*/
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");

        return "redirect:/";
    }


    //Postmapping på login
    /*Daniel
    * Martin*/
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        User user = userService.login(username,password);

        if(user == null){
            return "redirect:/";
        }  else {
            session.setAttribute("user", user);
            if(user.getRole().equals("forretningsudvikler"))return "redirect:/statistics";
            else return "redirect:/landingpage";

            }
        }

    }

