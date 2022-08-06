package com.epam.spring.homework5.controller;

import com.epam.spring.homework5.controller.api.UserDetailsAPI;
import com.epam.spring.homework5.controller.dto.UserDetailsDTO;
import com.epam.spring.homework5.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserDetailsController implements UserDetailsAPI {

    private UserDetailsService userDetailsService;

    @Override
    public UserDetailsDTO getUserDetails(int userDetailsId) {
        log.info("accepted request to get user details with id:{}", userDetailsId);
        return userDetailsService.getUserDetails(userDetailsId);
    }
}
