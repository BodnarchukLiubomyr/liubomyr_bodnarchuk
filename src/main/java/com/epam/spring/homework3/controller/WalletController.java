package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.WalletDTO;
import com.epam.spring.homework3.service.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WalletController {

    private WalletService walletService;

    @GetMapping("/wallet/{walletId}")
    public WalletDTO getWallet(@PathVariable int walletId) {
        log.info("accepted request to get wallet with id:{}", walletId);
        return walletService.getWallet(walletId);
    }
}
