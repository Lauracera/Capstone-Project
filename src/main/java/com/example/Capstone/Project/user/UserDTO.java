package com.example.Capstone.Project.user;

import com.example.Capstone.Project.enums.Season;
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

        public Season getSeason() {
                try {

                        return Season.valueOf(season);
                } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid Contract Typology value: " + season + ". Correct value: PART_TIME, FULL_TIME");
                }
        }
}
