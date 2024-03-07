package com.example.Capstone.Project.exceptions;

import org.springframework.validation.ObjectError;

import java.util.List;

public class BadRequestException extends RuntimeException{
    private List<ObjectError> errorList;

    public BadRequestException(String message) {
        super("Error caused by: " + message);
    }

    public BadRequestException(List<ObjectError> errorList) {
        super("Error in payload");
        this.errorList = errorList;
    }
}
