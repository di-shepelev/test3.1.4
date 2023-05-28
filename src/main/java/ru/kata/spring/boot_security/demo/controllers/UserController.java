package ru.kata.spring.boot_security.demo.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserServise;

import java.security.Principal;


@Controller
public class UserController {

    private final UserServise userServise;

    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/")
    public String start() {
        return "/login";
    }

    @GetMapping(value = "/user")
    public String updateUser(Principal principal, Model model) {

        User user = userServise.findByUsername(principal.getName());

        model.addAttribute("user", user);

        return "user";
    }


}
