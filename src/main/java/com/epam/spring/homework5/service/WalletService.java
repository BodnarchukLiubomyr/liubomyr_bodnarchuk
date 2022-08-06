package com.epam.spring.homework5.service;

import com.epam.spring.homework5.controller.dto.WalletDTO;

public interface WalletService {

    WalletDTO getWallet(int walletId);

    WalletDTO update(WalletDTO walletDTO);
}
