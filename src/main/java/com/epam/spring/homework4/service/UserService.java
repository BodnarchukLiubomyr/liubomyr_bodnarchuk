package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();

    UserDTO create(UserDTO userDTO);

    UserDTO getUser(String login);
}
