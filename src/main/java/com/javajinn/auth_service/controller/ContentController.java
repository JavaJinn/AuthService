package com.javajinn.auth_service.controller;

import jakarta.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javajinn.auth_service.dto.SignupRequest;
import com.javajinn.auth_service.service.RegistrationService;

@Controller
public class ContentController {

    private final RegistrationService registrationService;

    public ContentController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        model.addAttribute("displayName", authentication.getName());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        if (!model.containsAttribute("signupRequest")) {
            model.addAttribute("signupRequest", new SignupRequest());
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String register(
            @Valid @ModelAttribute("signupRequest") SignupRequest signupRequest,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            registrationService.register(signupRequest);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            bindingResult.reject("signup.error", ex.getMessage());
            return "signup";
        }

        redirectAttributes.addFlashAttribute("signupSuccess", "Account created successfully. You can log in now.");
        return "redirect:/login";
    }
}
