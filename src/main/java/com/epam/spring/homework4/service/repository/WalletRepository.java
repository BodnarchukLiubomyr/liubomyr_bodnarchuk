package com.epam.spring.homework4.service.repository;

import com.epam.spring.homework4.service.model.Wallet;

public interface WalletRepository {
    Wallet getUserWallet(int id);

    Wallet addChange(Wallet wallet);
}
