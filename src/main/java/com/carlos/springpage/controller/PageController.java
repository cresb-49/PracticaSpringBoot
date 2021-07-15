package com.carlos.springpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/userForm")
    public String userForm(Model model){
        return "user-form";
    }
}
