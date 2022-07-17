package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.WalletDTO;
import com.epam.spring.homework4.service.WalletService;
import com.epam.spring.homework4.service.exception.NotFoundException;
import com.epam.spring.homework4.service.exception.WalletNotFoundException;
import com.epam.spring.homework4.service.mapper.WalletMapper;
import com.epam.spring.homework4.service.model.Wallet;
import com.epam.spring.homework4.service.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletServiceImpl implements WalletService {

    private WalletRepository walletRepository;

    @Override
    public WalletDTO getWallet(int walletId) {
        log.info("receiving wallet with id:{}", walletId);
        if (walletRepository.getUserWallet(walletId) == null) {
            throw new WalletNotFoundException();
        }
        return WalletMapper.INSTANCE.mapWalletDto(walletRepository.getUserWallet(walletId));
    }

    @Override
    public WalletDTO update(WalletDTO walletDTO) {
        Wallet wallet = WalletMapper.INSTANCE.mapWallet(walletDTO);
        log.info("updating wallet with id:{}", walletDTO.getId());
        if (walletRepository.addChange(wallet) == null) {
            throw new WalletNotFoundException();
        }
        return WalletMapper.INSTANCE.mapWalletDto(walletRepository.addChange(wallet));
    }
}
