package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    boolean existsById(Integer id);
    boolean existsByService(String service);
    boolean existsByServiceOrIdIsNot(String service, Integer id);
    void deleteService(Integer id);
}
