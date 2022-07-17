package com.epam.spring.homework4.service.repository;

import com.epam.spring.homework4.service.model.UserDetails;

public interface UserDetailsRepository {
    UserDetails getUserDetails(int id);
}
