package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.UserDetailsDTO;

public interface UserDetailsService {
    UserDetailsDTO getUserDetails(int userDetailsId);
}
