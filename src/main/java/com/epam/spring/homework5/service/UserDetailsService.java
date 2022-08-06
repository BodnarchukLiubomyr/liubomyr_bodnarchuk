package com.epam.spring.homework5.service;

import com.epam.spring.homework5.controller.dto.UserDetailsDTO;

public interface UserDetailsService {
    UserDetailsDTO getUserDetails(int userDetailsId);
}
