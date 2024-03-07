package com.example.Capstone.Project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorsPayload {
    private String message;
    private LocalDateTime timestamp;

    public ErrorsPayload(String message, LocalDateTime now, List<String> errorsList) {
    }
}
