package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();

    UserDTO create(UserDTO userDTO);

    UserDTO getUser(String login);
}
