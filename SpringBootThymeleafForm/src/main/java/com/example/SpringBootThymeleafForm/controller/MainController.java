package com.example.SpringBootThymeleafForm.controller;

import java.util.*;

import javax.validation.Valid;

import com.example.SpringBootThymeleafForm.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// @Controller is responsible for processing incoming requests.
@Controller
public class MainController {

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Designer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }

    // @ModelAttr reads form data and sets the values to fields of the model object.
    // @Valid annotation and BindingResult are required for form validation
    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        System.out.println(user);
        // If the form has errors,revert to the form page and recreate list, otherwise
        // showing the result page.
        if (bindingResult.hasErrors()) {
            List<String> listProfession = Arrays.asList("Developer", "Designer", "Tester", "Architect");
            model.addAttribute("listProfession", listProfession);

            return "register_form";
        } else {
            return "register_success";
        }
    }

}