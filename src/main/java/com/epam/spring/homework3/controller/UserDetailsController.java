package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.UserDetailsDTO;
import com.epam.spring.homework3.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserDetailsController {

    private UserDetailsService userDetailsService;

    @GetMapping("/userDetails/{userDetailsId}")
    public UserDetailsDTO getUserDetails(@PathVariable int userDetailsId) {
        log.info("accepted request to get user details with id:{}", userDetailsId);
        return userDetailsService.getUserDetails(userDetailsId);
    }
}
