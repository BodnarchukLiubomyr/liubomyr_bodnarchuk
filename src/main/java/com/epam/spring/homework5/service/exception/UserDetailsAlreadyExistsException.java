package com.epam.spring.homework5.service.exception;

public class UserDetailsAlreadyExistsException extends ValidationException{
    private static final String MESSAGE = "User details with this email already exists!";

    public UserDetailsAlreadyExistsException() {
        super(MESSAGE);
    }
}
