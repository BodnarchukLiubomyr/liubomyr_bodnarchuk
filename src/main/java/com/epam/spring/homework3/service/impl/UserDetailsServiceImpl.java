package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.UserDetailsDTO;
import com.epam.spring.homework3.service.UserDetailsService;
import com.epam.spring.homework3.service.exception.NotFoundException;
import com.epam.spring.homework3.service.mapper.UserDetailsMapper;
import com.epam.spring.homework3.service.repository.UserDetailsRepository;
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
            throw new NotFoundException("No user`s details with id=" + userDetailsId + " was found to delete.");
        }
        return UserDetailsMapper.INSTANCE.mapUserDetailsDto(userDetailsRepository.getUserDetails(userDetailsId));
    }

}
