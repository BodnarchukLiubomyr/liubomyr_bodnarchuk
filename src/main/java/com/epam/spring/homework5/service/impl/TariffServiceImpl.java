package com.epam.spring.homework5.service.impl;

import com.epam.spring.homework5.controller.dto.ServiceDTO;
import com.epam.spring.homework5.controller.dto.TariffDTO;
import com.epam.spring.homework5.service.TariffService;
import com.epam.spring.homework5.service.exception.TariffAlreadyExistsException;
import com.epam.spring.homework5.service.exception.TariffNotFoundException;
import com.epam.spring.homework5.service.exception.UserNotFoundException;
import com.epam.spring.homework5.service.mapper.ServiceMapper;
import com.epam.spring.homework5.service.mapper.TariffMapper;
import com.epam.spring.homework5.service.model.Tariff;
import com.epam.spring.homework5.service.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    @Override
    @Transactional
    public Page<TariffDTO> getAll(int page, int size, String sortBy, String order) {
        log.info("reading tariffs");
        Pageable pageable = PageRequest.of(page, size,
                order.equals("desc") ? Sort.by(sortBy).descending()
                        : Sort.by(sortBy).ascending());
        Page<TariffDTO> tariffDTOS = tariffRepository.findAll(pageable)
                .map(TariffMapper.INSTANCE::mapTariffDto);
        log.info("tariffs were successfully read");
        return tariffDTOS;
    }

    @Override
    @Transactional
    public TariffDTO create(TariffDTO tariffDTO) {
        log.info("creating tariff with name:{}", tariffDTO.getName_en());
        if (tariffRepository.existsByNameOrId(tariffDTO.getName_en(),tariffDTO.getId())) {
            throw new TariffAlreadyExistsException();
        }
        Tariff tariff = tariffRepository.save(TariffMapper.INSTANCE.mapTariff(tariffDTO));
        return TariffMapper.INSTANCE.mapTariffDto(tariff);
    }

    @Override
    public void delete(int tariffId) {
        log.info("deleting tariff with id:{}", tariffId);
        if (tariffRepository.existsById(tariffId)) {
            throw new TariffNotFoundException();
        }
        tariffRepository.deleteById(tariffId);
    }

    @Override
    @Transactional
    public List<TariffDTO> getTariffs(ServiceDTO serviceDTO) {
        log.info("read tariffs with service:{}", serviceDTO);
        List<Tariff> tariffs = tariffRepository.findByService(ServiceMapper.INSTANCE.mapService(serviceDTO));
        if (tariffs.isEmpty()) {
            throw new UserNotFoundException();
        }
        return tariffs.stream().map(TariffMapper.INSTANCE::mapTariffDto).collect(Collectors.toList());
    }
}
