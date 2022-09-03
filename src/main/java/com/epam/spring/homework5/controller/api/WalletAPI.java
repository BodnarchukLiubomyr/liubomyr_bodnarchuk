package com.epam.spring.homework5.controller.api;

import com.epam.spring.homework5.controller.dto.WalletDTO;
import com.epam.spring.homework5.controller.dto.validation.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api("Wallet management API")
@RequestMapping("api/v1")
public interface WalletAPI {
    @ApiOperation("Find user's wallet")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/wallet/{walletId}")
    WalletDTO getWallet(@PathVariable int walletId);

    @ApiImplicitParams(
            @ApiImplicitParam(name = "body",
                    paramType = "body",
                    required = true,
                    value = "Wallet to be updated")
    )
    @ApiOperation("Update wallet")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/wallet")
    WalletDTO updateWallet(@RequestBody @Validated(OnUpdate.class) WalletDTO walletDTO);
}
