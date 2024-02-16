package net.sirdagron.bookstore.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.sirdagron.bookstore.domain.dto.UserDto;
import net.sirdagron.bookstore.domain.entities.User;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
public class RegistrationController {
    public RegistrationController()
    @GetMapping("/register")
    public String getRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }
    @PostMapping("/register")
    public ModelAndView registerUserForm(@ModelAttribute("user") @Valid UserDto userDto,
        HttpServletRequest request, Errors errors) {
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistsException e) {
            ModelAndView mav = new ModelAndView("register", "user", userDto);
            mav.addObject("message", "An account with that username/email already exists.");
            return mav;
        }
        return new ModelAndView("successRegister", "user", userDto);
    }
}
