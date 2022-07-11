package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.ServiceDTO;
import com.epam.spring.homework3.controller.dto.TariffDTO;
import com.epam.spring.homework3.service.TariffService;
import com.epam.spring.homework3.service.exception.NotFoundException;
import com.epam.spring.homework3.service.mapper.ServiceMapper;
import com.epam.spring.homework3.service.mapper.TariffMapper;
import com.epam.spring.homework3.service.model.Tariff;
import com.epam.spring.homework3.service.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class TariffServiceImpl implements TariffService {

    private TariffRepository tariffRepository;

    @Override
    public List<TariffDTO> getAll() {
        log.info("receiving all tariffs");
        return tariffRepository.selectTariffs().stream()
                .map(TariffMapper.INSTANCE::mapTariffDto)
                .sorted(Comparator.comparing(TariffDTO::getId)).collect(Collectors.toList());
    }

    @Override
    public TariffDTO create(TariffDTO tariffDTO) {
        log.info("creating tariff with name:{}", tariffDTO.getName_en());
        Tariff tariff = TariffMapper.INSTANCE.mapTariff(tariffDTO);
        return TariffMapper.INSTANCE.mapTariffDto(tariffRepository.insertTariff(tariff));
    }

    @Override
    public void delete(int tariffId) {
        log.info("deleting tariff with id:{}", tariffId);
        if (tariffRepository.selectTariff(tariffId) == null) {
            throw new NotFoundException("No tariff with id=" + tariffId + " was found to delete.");
        }
        tariffRepository.deleteTariff(tariffId);
    }

    @Override
    public List<TariffDTO> getTariffs(ServiceDTO serviceDTO) {
        log.info("receiving all tariffs with the same service");
        return tariffRepository.selectTariffs(ServiceMapper.INSTANCE.mapService(serviceDTO)).stream()
                .map(TariffMapper.INSTANCE::mapTariffDto)
                .sorted(Comparator.comparing(t -> t.getService().getService_en()))
                .collect(Collectors.toList());
    }
}
