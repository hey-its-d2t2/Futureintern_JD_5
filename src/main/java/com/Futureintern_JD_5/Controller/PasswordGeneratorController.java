package com.Futureintern_JD_5.Controller;

import com.Futureintern_JD_5.Service.PasswordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/password-generator")
public class PasswordGeneratorController {

    private final PasswordGeneratorService passwordGeneratorService;

    @Autowired
    public PasswordGeneratorController(PasswordGeneratorService passwordGeneratorService) {
        this.passwordGeneratorService = passwordGeneratorService;
    }

    // Serve the password generator page
    @GetMapping
    public String showPasswordGeneratorPage() {
        return "passwordgenerator";
    }

    // Generate passwords based on the user's input
    @PostMapping("/generate")
    public String generatePasswords(@RequestParam("length") int length,
                                    @RequestParam("quantity") int quantity,
                                    @RequestParam(value = "includeNumbers", required = false, defaultValue = "false") boolean includeNumbers,
                                    @RequestParam(value = "includeLowercase", required = false, defaultValue = "false") boolean includeLowercase,
                                    @RequestParam(value = "includeUppercase", required = false, defaultValue = "false") boolean includeUppercase,
                                    @RequestParam(value = "includeSymbols", required = false, defaultValue = "false") boolean includeSymbols,
                                    @RequestParam(value = "noSimilarChars", required = false, defaultValue = "false") boolean noSimilarChars,
                                    @RequestParam(value = "noDuplicateChars", required = false, defaultValue = "false") boolean noDuplicateChars,
                                    @RequestParam(value = "noSequentialChars", required = false, defaultValue = "false") boolean noSequentialChars,
                                    Model model) {

        // Generate the passwords using the service
        List<String> passwords = passwordGeneratorService.generatePasswords(length, quantity, includeNumbers,
                includeLowercase, includeUppercase, includeSymbols,
                noSimilarChars, noDuplicateChars, noSequentialChars);

        // Add generated passwords to the model to pass them to the view
        model.addAttribute("passwords", passwords);

        // Return the same page with the generated passwords displayed
        return "passwordgenerator";
    }

}
