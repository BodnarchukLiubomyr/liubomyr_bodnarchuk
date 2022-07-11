package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.model.UserSuggestion;
import com.epam.spring.homework3.service.repository.UserSuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserSuggestionRepositoryImpl implements UserSuggestionRepository {
    private int id;
    private final List<UserSuggestion> userSuggestions = new ArrayList<>();

    @Override
    public UserSuggestion insertSuggestion(UserSuggestion userSuggestion) {
        id++;
        userSuggestion.setId(id);
        userSuggestions.add(userSuggestion);
        log.info("successfully created user`s suggestion with id:{}", userSuggestion.getId());
        return userSuggestion;
    }

    @Override
    public List<UserSuggestion> selectSuggestions() {
        log.info("successfully received users` suggestions");
        return new ArrayList<>(userSuggestions);
    }

}
