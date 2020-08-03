package com.ecommerce.orderapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String homePage(Authentication authentication, Model model) {
        //System.out.println("keziban test: "+authentication.getName());
        //System.out.println("keziban test: "+authentication.getPrincipal());
        //System.out.println("keziban test: "+authentication.getDetails());
        //System.out.println("keziban test: "+authentication.getCredentials());

        //CustomUser customUser = (CustomUser) authentication.getPrincipal();
        //Long userId = customUser.getId();
        //System.out.println("user id: "+userId);

        model.addAttribute("user", authentication.getName());
        return "home";
    }
}
