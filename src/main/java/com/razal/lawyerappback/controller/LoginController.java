package com.razal.lawyerappback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    String login(Model model){

        model.addAttribute("something","This is login method");

        return "login-page";
    }


}
