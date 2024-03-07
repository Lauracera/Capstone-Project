package com.example.Capstone.Project.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorsPayloadWithList {
    private List<String> errorsList;

    public ErrorsPayloadWithList(String message, LocalDateTime timestamp, List<String> errorsList) {
        super();
        this.errorsList = errorsList;
    }
}
