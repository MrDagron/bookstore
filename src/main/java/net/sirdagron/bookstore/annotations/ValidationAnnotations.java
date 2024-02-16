package net.sirdagron.bookstore.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import net.sirdagron.bookstore.services.validators.EmailValidatorService;
import net.sirdagron.bookstore.services.validators.PasswordMatchesValidatorService;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

public class ValidationAnnotations {
    @Target({TYPE, FIELD, ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = EmailValidatorService.class)
    @Documented
    public @interface ValidEmail {
        String message() default "Invalid email";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = PasswordMatchesValidatorService.class)
    @Documented
    public @interface PasswordMatches {
        String message() default "Passwords do not match";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
