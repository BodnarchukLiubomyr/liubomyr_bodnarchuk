package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.UserDetailsDTO;
import com.epam.spring.homework4.service.UserDetailsService;
import com.epam.spring.homework4.service.exception.NotFoundException;
import com.epam.spring.homework4.service.exception.UserDetailsNotFoundException;
import com.epam.spring.homework4.service.mapper.UserDetailsMapper;
import com.epam.spring.homework4.service.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetailsDTO getUserDetails(int userDetailsId) {
        log.info("receiving user`s details with id:{}", userDetailsId);
        if (userDetailsRepository.getUserDetails(userDetailsId) == null) {
            throw new UserDetailsNotFoundException();
        }
        return UserDetailsMapper.INSTANCE.mapUserDetailsDto(userDetailsRepository.getUserDetails(userDetailsId));
    }

}
