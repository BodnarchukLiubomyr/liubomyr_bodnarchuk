package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.Service;
import com.epam.spring.homework3.service.model.Tariff;

import java.util.List;

public interface TariffRepository {
    Tariff insertTariff(Tariff tariff);

    Tariff selectTariff(int id);

    void deleteTariff(int id);

    List<Tariff> selectTariffs();

    List<Tariff> selectTariffs(Service service);
}
