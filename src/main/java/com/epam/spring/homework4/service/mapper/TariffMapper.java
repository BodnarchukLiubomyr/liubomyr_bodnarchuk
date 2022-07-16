package com.epam.spring.homework4.service.mapper;

import com.epam.spring.homework4.controller.dto.TariffDTO;
import com.epam.spring.homework4.service.model.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ServiceMapper.class})
public interface TariffMapper {
    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    TariffDTO mapTariffDto(Tariff tariff);

    Tariff mapTariff(TariffDTO tariffDTO);
}
