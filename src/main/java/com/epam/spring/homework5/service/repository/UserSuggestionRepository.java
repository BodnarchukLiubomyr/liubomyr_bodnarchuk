package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.UserSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSuggestionRepository extends JpaRepository<UserSuggestion,Integer> {
    boolean existsById(Integer id);

    @Query("select case when count(t)> 0 then true else false end from UserSuggestion t where t.name_en = :name_en or t.id = :id")
    boolean existsByNameOrId(@Param("name_en")String name, @Param("id") Integer id);
}
