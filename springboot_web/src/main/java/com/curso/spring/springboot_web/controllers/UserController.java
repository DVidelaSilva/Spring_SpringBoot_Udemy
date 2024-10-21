package com.curso.spring.springboot_web.controllers;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.curso.spring.springboot_web.models.User;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model ){

        User user = new User("Diego",  "Videla");
        user.setEmail("dvidela@mail.com");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado de Usuarios");
        return "list";
    }


    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
            new User("Pepa", "Gonzalez", "pepa@correo.com"),
            new User("Lalo", "Perez"),
            new User("Juanita", "Roe", "juana@correo.com"),
            new User("Andres", "Doe")
            );
    }
    

} 


 