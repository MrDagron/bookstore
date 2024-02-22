package net.sirdagron.bookstore.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.sirdagron.bookstore.annotations.ValidationAnnotations;
@Setter
@Getter
@ValidationAnnotations.PasswordMatches
public class UserDto {
    @ValidationAnnotations.ValidEmail
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

}
