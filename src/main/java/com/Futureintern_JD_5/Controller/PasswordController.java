package com.Futureintern_JD_5.Controller;

import com.Futureintern_JD_5.Service.PasswordGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    private final PasswordGeneratorService passwordGeneratorService;


    public PasswordController(PasswordGeneratorService passwordGeneratorService) {
        this.passwordGeneratorService = passwordGeneratorService;
    }

    @GetMapping("/generate-password")
    public String showPasswordForm() {
        return "generate_password";
    }

    @PostMapping("/generate-password")
    public String generatePassword(@RequestParam("length") int length,
                                   @RequestParam(value = "useUpper", required = false) boolean useUpper,
                                   @RequestParam(value = "useLower", required = false) boolean useLower,
                                   @RequestParam(value = "useDigits", required = false) boolean useDigits,
                                   @RequestParam(value = "useSpecial", required = false) boolean useSpecial,
                                   Model model) {
        if (length > 99999) {
            model.addAttribute("error", "Password length must not exceed 99,999 characters.");
            return "generate_password";
        }

        String password = passwordGeneratorService.generatePassword(length, useUpper, useLower, useDigits, useSpecial);
        model.addAttribute("generatedPassword", password);
        return "password_result";
    }
}
