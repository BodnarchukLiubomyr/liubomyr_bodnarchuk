package com.epam.spring.homework5.service.exception;

public class ServiceNotFoundException extends NotFoundException{
    private static final String MESSAGE = "Service was not found!";

    public ServiceNotFoundException() {
        super(MESSAGE);
    }
}
