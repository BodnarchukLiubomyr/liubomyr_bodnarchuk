package com.epam.spring.homework5.service.exception;

public class UserAlreadyExistsException extends ValidationException{
    private static final String MESSAGE = "User with this login already exists!";

    public UserAlreadyExistsException() {
        super(MESSAGE);
    }
}
