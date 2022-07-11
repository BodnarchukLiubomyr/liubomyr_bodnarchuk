package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.UserDTO;
import com.epam.spring.homework3.service.UserService;
import com.epam.spring.homework3.service.exception.NotFoundException;
import com.epam.spring.homework3.service.mapper.UserMapper;
import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        log.info("receiving all users");
        return userRepository.getAllUsers().stream()
                .map(UserMapper.INSTANCE::mapUserDto)
                .sorted(Comparator.comparing(UserDTO::getId)).collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        log.info("creating user with login:{}", userDTO.getLogin());
        User user = UserMapper.INSTANCE.mapUser(userDTO);
        return UserMapper.INSTANCE.mapUserDto(userRepository.insertUser(user));
    }

    @Override
    public UserDTO getUser(String login) {
        log.info("receiving wallet with id:{}", login);
        if (userRepository.getUser(login) == null) {
            throw new NotFoundException("No wallet with id=" + login + " was found to delete.");
        }
        return UserMapper.INSTANCE.mapUserDto(userRepository.getUser(login));
    }
}

