package com.epam.spring.homework3.service.mapper;

import com.epam.spring.homework3.controller.dto.WalletDTO;
import com.epam.spring.homework3.service.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletMapper {
    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);

    WalletDTO mapWalletDto(Wallet wallet);

    Wallet mapWallet(WalletDTO walletDTO);
}
