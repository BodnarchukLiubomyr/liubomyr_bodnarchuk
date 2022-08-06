package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.Service;
import com.epam.spring.homework5.service.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepository extends JpaRepository<Tariff,Integer> {
    boolean existsById(Integer id);

    List<Tariff> findByService(Service service);

    boolean existsByNameOrId(String name,Integer id);

    boolean existsByNameOrIdIsNot(String name, Integer id);

    void deleteTariff(Integer id);

}
