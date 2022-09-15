package com.epam.spring.homework5.controller;

import com.epam.spring.homework5.controller.api.WalletAPI;
import com.epam.spring.homework5.controller.dto.PlaceDTO;
import com.epam.spring.homework5.controller.dto.WalletDTO;
import com.epam.spring.homework5.service.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WalletController implements WalletAPI {

    private WalletService walletService;

    @Override
    public WalletDTO getWallet(int walletId) {
        log.info("accepted request to get wallet with id:{}", walletId);
        return walletService.getWallet(walletId);
    }

    @Override
    public WalletDTO updateWallet(WalletDTO walletDTO) {
        log.info("accepted request to update place with id:{}", walletDTO.getId());
        return walletService.update(walletDTO);
    }


}
