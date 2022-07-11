package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Tariff;
import com.epam.spring.homework3.service.model.UserDetails;
import com.epam.spring.homework3.service.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    private int id;
    private final List<UserDetails> details = new ArrayList<>();

    @Override
    public UserDetails getUserDetails(int id) {
        UserDetails detail = details.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (detail != null){
            log.info("user details with this id is found: {}", detail.getId());
        }
        else {
            log.info("user with this id doesn't exist: {}", id);
        }
        return detail;
    }
}
