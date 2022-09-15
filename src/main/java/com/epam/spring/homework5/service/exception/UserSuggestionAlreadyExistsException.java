package com.epam.spring.homework5.service.exception;

public class UserSuggestionAlreadyExistsException extends ValidationException{
    private static final String MESSAGE = "User suggestion with this name already exists!";

    public UserSuggestionAlreadyExistsException() {
        super(MESSAGE);
    }
}
