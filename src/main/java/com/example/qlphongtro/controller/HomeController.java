package com.example.qlphongtro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homeRedirect() {
        return "redirect:/dashboard";
    }

    @GetMapping("/home-dashboard")

    public String dashboard() {
        return "dashboard";
    }
}
