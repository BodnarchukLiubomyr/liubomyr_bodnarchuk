package com.epam.spring.homework5.service.exception;

public class UserDetailsNotFoundException extends NotFoundException{

    private static final String MESSAGE = "User details was not found!";

    public UserDetailsNotFoundException() {
        super(MESSAGE);
    }
}
