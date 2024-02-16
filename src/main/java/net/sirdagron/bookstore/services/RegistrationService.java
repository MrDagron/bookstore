package net.sirdagron.bookstore.services;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import net.sirdagron.bookstore.domain.dto.UserDto;
import net.sirdagron.bookstore.domain.entities.User;
import net.sirdagron.bookstore.domain.enums.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RegistrationService {
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }
    public String register(UserDto userDto) {
        return userService.registerNewUser(new User(
                userDto.getEmail(),
                userDto.getPassword(),
                false,
                true,
                UserRole.USER
        ));
    }
    /*public String register(UserDto userDto) {
        try(ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
            if(violations.isEmpty()) {
                return userService.registerNewUser(new User(
                        userDto.getEmail(),
                        userDto.getPassword(),
                        false,
                        true,
                        UserRole.USER
                ));
            } else {
                for (ConstraintViolation<UserDto> violation : violations) {
                    //todo: log error
                }
                return "failed_registration";
            }
        }
    }*/
}
