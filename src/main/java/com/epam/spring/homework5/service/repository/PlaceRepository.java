package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
    boolean existsById(Integer id);
    boolean existsByIdIsNot(Integer id);
}
