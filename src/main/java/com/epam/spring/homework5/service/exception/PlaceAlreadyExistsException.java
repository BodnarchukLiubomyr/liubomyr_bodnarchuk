package com.epam.spring.homework5.service.exception;

public class PlaceAlreadyExistsException extends ValidationException{
    private static final String MESSAGE = "Place with this name already exists!";

    public PlaceAlreadyExistsException() {
        super(MESSAGE);
    }
}
