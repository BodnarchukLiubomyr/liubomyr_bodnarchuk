package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Wallet;
import com.epam.spring.homework3.service.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletRepositoryImpl implements WalletRepository {

    private int id;
    private final List<Wallet> wallets = new ArrayList<>();

    @Override
    public Wallet getUserWallet(int id) {
        Wallet wallet = wallets.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (wallet != null){
            log.info("wallet with this id is found: {}", wallet.getId());
        }
        else {
            log.info("wallet with this id doesn't exist: {}", id);
        }
        return wallet;
    }

    @Override
    public Wallet addChange(Wallet entity){
        Wallet wallet = null;
        Optional<Wallet> walletOptional = wallets.stream()
                .filter(a -> a.getId() == entity.getId())
                .findFirst();
        if (walletOptional.isPresent()) {
            wallet = walletOptional.get();
            wallet.setFunds(wallet.getFunds());
            wallet.setChange(wallet.getChange());
        }
        return wallet;
    }
}
