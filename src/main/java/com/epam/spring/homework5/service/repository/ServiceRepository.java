package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    boolean existsById(Integer id);

    @Query("select case when count(t)> 0 then true else false end from Service t where t.service_en = :service_en")
    boolean existsByService(@Param("service_en") String service_en);

    void deleteById(Integer id);
}
