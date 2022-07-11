package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Service;
import com.epam.spring.homework3.service.model.Tariff;
import com.epam.spring.homework3.service.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class TariffRepositoryImpl implements TariffRepository {

    private int id;
    private String service;
    private final List<Tariff> tariffs = new ArrayList<>();

    @Override
    public Tariff insertTariff(Tariff tariff) {
        id++;
        tariff.setId(id);
        tariffs.add(tariff);
        log.info("successfully created tariff with id:{}", tariff.getId());
        return (Tariff) tariffs;
    }

    @Override
    public Tariff selectTariff(int id) {
        Tariff tariff = tariffs.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (tariff != null){
            log.info("tariff with this id is found: {}", tariff.getId());
        }
        else {
            log.info("tariff with this id doesn't exist: {}", id);
        }
        return tariff;
    }

    @Override
    public void deleteTariff(int id) {
        tariffs.removeIf(u -> u.getId() == id);
        log.info("successfully deleted tariff with id:{}", id);
    }

    @Override
    public List<Tariff> selectTariffs() {
        log.info("successfully received tariffs");
        return new ArrayList<>(tariffs);
    }

    @Override
    public List<Tariff> selectTariffs(Service service) {
        log.info("successfully received tariffs of this service");
        return tariffs.stream().filter(a -> a.getService().equals(service)).collect(Collectors.toList());
    }
}
