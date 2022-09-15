package com.epam.spring.homework5.service.exception;

public class TariffAlreadyExistsException extends ValidationException{
    private static final String MESSAGE = "Tariff with this name already exists!";

    public TariffAlreadyExistsException() {
        super(MESSAGE);
    }
}
