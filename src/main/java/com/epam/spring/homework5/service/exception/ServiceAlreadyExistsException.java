package com.epam.spring.homework5.service.exception;

public class ServiceAlreadyExistsException extends ValidationException{
    private static final String MESSAGE = "Service with this name already exists!";

    public ServiceAlreadyExistsException() {
        super(MESSAGE);
    }
}
