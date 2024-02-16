package net.sirdagron.bookstore.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.sirdagron.bookstore.domain.dto.UserDto;
import net.sirdagron.bookstore.domain.entities.User;
import net.sirdagron.bookstore.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class RegistrationController {
    private final RegistrationService registrationService;
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping("/register")
    public ModelAndView getRegistrationForm() {
        UserDto userDto = new UserDto();
        return new ModelAndView("register", "user", userDto);
    }
    @PostMapping("/register")
    public ModelAndView registerUser(@Valid @ModelAttribute UserDto userDto, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            return new ModelAndView("register", model);
        }
        try {
            String regUser = registrationService.register(userDto);
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("email", regUser);
            return new ModelAndView("welcome", modelMap);

        } catch (IllegalStateException ex) {
            //todo: log
            return new ModelAndView("error");
        }
    }
}
