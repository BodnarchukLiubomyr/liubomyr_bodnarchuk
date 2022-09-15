package com.epam.spring.homework5.service;

import com.epam.spring.homework5.controller.dto.ServiceDTO;
import com.epam.spring.homework5.controller.dto.TariffDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TariffService {
    Page<TariffDTO> getAll(int page, int size, String sortBy, String order);

    TariffDTO create(TariffDTO tariffDTO);

    void delete(int tariffId);

    List<TariffDTO> getTariffs(ServiceDTO serviceDTO);
}
