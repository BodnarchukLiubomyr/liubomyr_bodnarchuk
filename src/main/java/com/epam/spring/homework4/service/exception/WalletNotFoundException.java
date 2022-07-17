package com.epam.spring.homework4.service.exception;

public class WalletNotFoundException extends NotFoundException{
    private static final String MESSAGE = "Wallet was not found!";

    public WalletNotFoundException(){
        super(MESSAGE);
    }
}
