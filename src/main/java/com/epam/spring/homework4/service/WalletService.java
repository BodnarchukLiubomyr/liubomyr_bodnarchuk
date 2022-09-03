package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.WalletDTO;

public interface WalletService {

    WalletDTO getWallet(int walletId);

    WalletDTO update(WalletDTO walletDTO);
}
