package dev.ivanwilhelm.users.infrastructure.api.users.create_user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CreateUserRequestDto {
    @NotNull(message = "First name is required.")
    @Length(min = 3, max = 50, message = "First name must be between 3 and 50 characters.")
    private String firstName;

    @NotNull(message = "Last name is required.")
    @Length(min = 3, max = 50, message = "Last name must be between 3 and 50 characters.")
    private String lastName;

    @NotNull(message = "Email is required.")
    @Length(min = 5, max = 100, message = "Email must be between 5 and 100 characters.")
    @Email(message = "Email must be a valid email address.")
    private String email;
}
