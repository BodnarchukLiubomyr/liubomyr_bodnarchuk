package com.epam.spring.homework5.service.exception;

public class WalletAlreadyExistsException extends ValidationException{
    private static final String MESSAGE = "Wallet with this id already exists!";

    public WalletAlreadyExistsException() {
        super(MESSAGE);
    }
}
