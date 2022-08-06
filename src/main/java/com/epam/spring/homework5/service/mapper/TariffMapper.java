package com.epam.spring.homework5.service.mapper;

import com.epam.spring.homework5.controller.dto.TariffDTO;
import com.epam.spring.homework5.service.model.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ServiceMapper.class},nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TariffMapper {
    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    TariffDTO mapTariffDto(Tariff tariff);

    Tariff mapTariff(TariffDTO tariffDTO);
}
