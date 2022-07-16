package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.UserDTO;
import com.epam.spring.homework4.service.UserService;
import com.epam.spring.homework4.service.exception.NotFoundException;
import com.epam.spring.homework4.service.exception.UserNotFoundException;
import com.epam.spring.homework4.service.mapper.UserMapper;
import com.epam.spring.homework4.service.model.User;
import com.epam.spring.homework4.service.repository.UserRepository;
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
        log.info("receiving user with id:{}", login);
        if (userRepository.getUser(login) == null) {
            throw new UserNotFoundException();
        }
        return UserMapper.INSTANCE.mapUserDto(userRepository.getUser(login));
    }
}

