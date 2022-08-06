package com.epam.spring.homework5.service.impl;

import com.epam.spring.homework5.controller.dto.UserDetailsDTO;
import com.epam.spring.homework5.service.UserDetailsService;
import com.epam.spring.homework5.service.exception.PlaceNotFoundException;
import com.epam.spring.homework5.service.mapper.UserDetailsMapper;
import com.epam.spring.homework5.service.model.UserDetails;
import com.epam.spring.homework5.service.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    @Transactional
    public UserDetailsDTO getUserDetails(int userDetailsId) {
        log.info("read user details with id:{}", userDetailsId);
        Optional<UserDetails> optionalUserDetails = userDetailsRepository.findById(userDetailsId);
        if (optionalUserDetails.isEmpty()) {
            throw new PlaceNotFoundException();
        }
        return UserDetailsMapper.INSTANCE.mapUserDetailsDto(optionalUserDetails.get());
    }

}
