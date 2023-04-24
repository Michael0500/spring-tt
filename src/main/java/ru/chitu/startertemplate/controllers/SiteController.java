package ru.chitu.startertemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SiteController {
    @Autowired
    private UserDetailsService service;

    @GetMapping("/")
    public String index() {
        return "site/index";
    }

    @GetMapping("/light")
    public String light() {
        return "site/index-light";
    }

    @GetMapping("/dark")
    public String dark() {
        return "site/index-dark";
    }

    @GetMapping("/user")
    public String user(Model model) {
        UserDetails admin = service.loadUserByUsername("admin");
        model.addAttribute("user", admin);
        return "site/user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "site/admin";
    }

    @GetMapping("/login")
    public String login() {
        return "site/login";
    }
}
