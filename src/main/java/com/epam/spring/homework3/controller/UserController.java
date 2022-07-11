package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.UserDTO;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        log.info("accepted request to create user with login:{}", userDTO.getLogin());
        return userService.create(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    public List<UserDTO> getAllUsers() {
        log.info("accepted request to get all users");
        return userService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{login}")
    public UserDTO getUser(@PathVariable String login) {
        log.info("accepted request to get user with login");
        return userService.getUser(login);
    }
}
