package com.epam.spring.homework5.service.mapper;

import com.epam.spring.homework5.controller.dto.WalletDTO;
import com.epam.spring.homework5.service.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WalletMapper {

    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);

    WalletDTO mapWalletDto(Wallet wallet);

    @Mapping(target = "id", defaultValue = "0")
    Wallet mapWallet(WalletDTO walletDTO);

    void mapPresentFields(@MappingTarget Wallet toWallet, Wallet fromWallet);
}
