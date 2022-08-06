package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.UserSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSuggestionRepository extends JpaRepository<UserSuggestion,Integer> {
    boolean existsById(Integer id);
    boolean existsByName(String name);
    boolean existsByNameOrIdIsNot(String name, Integer id);
}
