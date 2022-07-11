package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.Wallet;

public interface WalletRepository {
    Wallet getUserWallet(int id);

    Wallet addChange(Wallet wallet);
}
