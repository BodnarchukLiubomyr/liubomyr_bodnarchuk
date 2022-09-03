package com.epam.spring.homework5.service.impl;

import com.epam.spring.homework5.controller.dto.UserDTO;
import com.epam.spring.homework5.service.UserService;
import com.epam.spring.homework5.service.exception.UserAlreadyExistsException;
import com.epam.spring.homework5.service.exception.UserNotFoundException;
import com.epam.spring.homework5.service.mapper.UserMapper;
import com.epam.spring.homework5.service.model.User;
import com.epam.spring.homework5.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public Page<UserDTO> getAll(int page, int size, String sortBy, String order) {
        log.info("reading users");
        Pageable pageable = PageRequest.of(page, size,
                order.equals("desc") ? Sort.by(sortBy).descending()
                        : Sort.by(sortBy).ascending());
        Page<UserDTO> userDTOS = userRepository.findAll(pageable)
                .map(UserMapper.INSTANCE::mapUserDto);
        log.info("users were successfully read");
        return userDTOS;
    }

    @Override
    @Transactional
    public UserDTO create(UserDTO userDTO) {
        log.info("creating user with login:{}", userDTO.getLogin());
        if (userRepository.existsByLoginOrId(userDTO.getLogin(), userDTO.getId())) {
            throw new UserAlreadyExistsException();
        }
        User user = userRepository.save(UserMapper.INSTANCE.mapUser(userDTO));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    @Transactional
    public UserDTO getUser(String login) {
        log.info("got user with login:{}", login);
        Optional<User> optionalUser = userRepository.findByLogin(login);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        return UserMapper.INSTANCE.mapUserDto(optionalUser.get());
    }
}

