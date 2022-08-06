package com.epam.spring.homework5.service.exception;

public class PlaceNotFoundException extends NotFoundException {

    private static final String MESSAGE = "Place was not found!";

    public PlaceNotFoundException() {
        super(MESSAGE);
    }
}
