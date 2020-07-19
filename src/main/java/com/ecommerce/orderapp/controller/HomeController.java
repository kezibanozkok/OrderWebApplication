package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public ModelAndView homePage(@AuthenticationPrincipal User user) {
        return new ModelAndView("home", "user", user);
    }
}
