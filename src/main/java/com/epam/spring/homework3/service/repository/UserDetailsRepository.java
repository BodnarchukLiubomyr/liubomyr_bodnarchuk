package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.UserDetails;

public interface UserDetailsRepository {
    UserDetails getUserDetails(int id);
}
