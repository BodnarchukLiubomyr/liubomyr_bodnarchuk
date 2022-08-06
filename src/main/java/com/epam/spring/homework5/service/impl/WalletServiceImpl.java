package com.epam.spring.homework5.service.impl;

import com.epam.spring.homework5.controller.dto.WalletDTO;
import com.epam.spring.homework5.service.WalletService;
import com.epam.spring.homework5.service.exception.WalletAlreadyExistsException;
import com.epam.spring.homework5.service.exception.WalletNotFoundException;
import com.epam.spring.homework5.service.mapper.WalletMapper;
import com.epam.spring.homework5.service.model.Wallet;
import com.epam.spring.homework5.service.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    @Transactional
    public WalletDTO getWallet(int walletId) {
        log.info("got place with id:{}", walletId);
        Optional<Wallet> optionalWallet = walletRepository.findById(walletId);
        if (optionalWallet.isEmpty()) {
            throw new WalletNotFoundException();
        }
        return WalletMapper.INSTANCE.mapWalletDto(optionalWallet.get());
    }

    @Override
    @Transactional
    public WalletDTO update(WalletDTO walletDTO) {
        log.info("updating wallet with id:{}", walletDTO.getId());
        Optional<Wallet> walletOptional = walletRepository.findById(walletDTO.getId());
        if (walletOptional.isEmpty()) {
            throw new WalletNotFoundException();
        }
        if (walletRepository.existsByIdIsNot(walletDTO.getId())){
            throw new WalletAlreadyExistsException();
        }
        Wallet wallet = walletOptional.get();
        WalletMapper.INSTANCE.mapPresentFields(wallet,WalletMapper.INSTANCE.mapWallet(walletDTO));
        Wallet updatedWallet = walletRepository.save(wallet);
        log.info("wallet with id:{} was successfully updated", updatedWallet.getId());
        return WalletMapper.INSTANCE.mapWalletDto(updatedWallet);
    }
}
