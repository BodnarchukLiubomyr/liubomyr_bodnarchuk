package com.epam.spring.homework4.service.repository;

import com.epam.spring.homework4.service.model.User;

import java.util.List;

public interface UserRepository {
    User insertUser(User entity);

    User getUser(String login);

    List<User> getAllUsers();
}
