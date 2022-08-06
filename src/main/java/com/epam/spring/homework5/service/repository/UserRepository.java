package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsById(Integer id);
    Optional<User> findByLogin(String login);
    boolean existsByLoginOrId(String login, Integer id);
    boolean existsByLoginOrIdIsNot(String login, Integer id);
}
