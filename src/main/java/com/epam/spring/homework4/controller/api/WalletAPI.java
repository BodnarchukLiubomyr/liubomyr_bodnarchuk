package com.epam.spring.homework4.controller.api;

import com.epam.spring.homework4.controller.dto.WalletDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api("Wallet management API")
@RequestMapping("api/v1")
public interface WalletAPI {
    @ApiOperation("Find user's wallet")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/wallet/{walletId}")
    WalletDTO getWallet(@PathVariable int walletId);
}
