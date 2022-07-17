package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.api.UserAPI;
import com.epam.spring.homework4.controller.dto.UserDTO;
import com.epam.spring.homework4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController implements UserAPI {
    private final UserService userService;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("accepted request to create user with login:{}", userDTO.getLogin());
        return userService.create(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("accepted request to get all users");
        return userService.getAll();
    }

    @Override
    public UserDTO getUser(String login) {
        log.info("accepted request to get user with login");
        return userService.getUser(login);
    }
}
