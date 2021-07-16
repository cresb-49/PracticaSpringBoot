package com.carlos.springpage.controller;

import com.carlos.springpage.entity.User;
import com.carlos.springpage.repository.RoleRepository;
import com.carlos.springpage.repository.UserRepository;
import com.carlos.springpage.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/userForm")
    public String userForm(Model model){
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("userForm", new User());
        model.addAttribute("listTab","active");
        return "user-form/user-view";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "";
    }
}
