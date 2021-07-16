package com.carlos.springpage.controller;

import javax.validation.Valid;

import com.carlos.springpage.entity.User;
import com.carlos.springpage.repository.RoleRepository;
import com.carlos.springpage.repository.UserRepository;
import com.carlos.springpage.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/userForm")
    public String createdUser(@Valid @ModelAttribute("userForm")User user,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("userForm",user);
            model.addAttribute("formTab","active");
        }
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roles", roleRepository.findAll());

        return "user-form/user-view";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "";
    }
}
