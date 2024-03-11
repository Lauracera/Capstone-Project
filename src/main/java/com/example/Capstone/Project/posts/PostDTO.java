package com.example.Capstone.Project.posts;

import jakarta.validation.constraints.NotNull;

public record PostDTO(
        @NotNull(message = "Inserire il titolo del post")
        String title,
        @NotNull(message = "Inserire il corpo del post")
        String bodyText
) {
}
