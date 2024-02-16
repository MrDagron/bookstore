package net.sirdagron.bookstore.services.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import net.sirdagron.bookstore.annotations.ValidationAnnotations;
import net.sirdagron.bookstore.domain.dto.UserDto;

public class PasswordMatchesValidatorService
        implements ConstraintValidator<ValidationAnnotations.PasswordMatches, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDto userDto = (UserDto) o;
        return userDto.getPassword().equals(userDto.getMatchingPassword());
    }
}
