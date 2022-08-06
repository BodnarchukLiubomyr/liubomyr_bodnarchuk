package com.epam.spring.homework5.service;

import com.epam.spring.homework5.controller.dto.UserDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    Page<UserDTO> getAll(int page, int size, String sortBy, String order);

    UserDTO create(UserDTO userDTO);

    UserDTO getUser(String login);
}
