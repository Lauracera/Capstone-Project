package com.example.Capstone.Project.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotEmpty(message = "Campo richiesto!")
        @Size(min = 3, max = 20, message = "Il campo deve avere caratteri compresi tra 3 e 20")
        String name,
        @NotEmpty(message = "Campo richiesto!")
        @Size(min = 3, max = 20, message = "Il campo deve avere caratteri compresi tra 3 e 20")
        String surname,
        @NotEmpty(message = "Campo richiesto!")
        @Email(message = "Email non valida")
        String email,
        @NotEmpty(message="Campo richiesto!")
        String season,
        @NotEmpty(message = "Campo richiesto!")
        @Size(min = 3, max = 20, message = "Il campo deve avere caratteri compresi tra 3 e 20")
        String password
) {
}
