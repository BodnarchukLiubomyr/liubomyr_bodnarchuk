package com.epam.spring.homework5.service.exception;

public class TariffNotFoundException extends NotFoundException{
    private static final String MESSAGE = "Tariff was not found!";

    public TariffNotFoundException() {
        super(MESSAGE);
    }
}
