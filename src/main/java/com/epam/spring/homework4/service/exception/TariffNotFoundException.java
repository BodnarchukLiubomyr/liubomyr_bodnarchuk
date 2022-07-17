package com.epam.spring.homework4.service.exception;

public class TariffNotFoundException extends NotFoundException{
    private static final String MESSAGE = "Tariff was not found!";

    public TariffNotFoundException() {
        super(MESSAGE);
    }
}
