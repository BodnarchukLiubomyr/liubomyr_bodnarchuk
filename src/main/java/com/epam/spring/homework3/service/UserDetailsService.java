package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.UserDetailsDTO;

public interface UserDetailsService {
    UserDetailsDTO getUserDetails(int userDetailsId);
}
