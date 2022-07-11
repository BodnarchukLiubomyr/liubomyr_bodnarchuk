package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.WalletDTO;

public interface WalletService {

    WalletDTO getWallet(int walletId);

    WalletDTO update(WalletDTO walletDTO);
}
