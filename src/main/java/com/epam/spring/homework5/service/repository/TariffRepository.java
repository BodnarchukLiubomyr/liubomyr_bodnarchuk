package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.Service;
import com.epam.spring.homework5.service.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepository extends JpaRepository<Tariff,Integer> {
    boolean existsById(Integer id);

    List<Tariff> findByService(Service service);

    @Query("select case when count(t)> 0 then true else false end from Tariff t where t.name_en = :name_en or t.id = :id")
    boolean existsByNameOrId(@Param("name_en")String name_en, @Param("id") Integer id);

    void deleteById(Integer id);
}
