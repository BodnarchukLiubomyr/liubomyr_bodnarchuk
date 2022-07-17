package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.ServiceDTO;
import com.epam.spring.homework4.controller.dto.TariffDTO;

import java.util.List;

public interface TariffService {
    List<TariffDTO> getAll();

    TariffDTO create(TariffDTO tariffDTO);

    void delete(int tariffId);

    List<TariffDTO> getTariffs(ServiceDTO serviceDTO);
}
