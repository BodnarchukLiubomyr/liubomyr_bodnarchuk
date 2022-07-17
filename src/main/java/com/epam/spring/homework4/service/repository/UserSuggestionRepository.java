package com.epam.spring.homework4.service.repository;

import com.epam.spring.homework4.service.model.UserSuggestion;

import java.util.List;

public interface UserSuggestionRepository {
    UserSuggestion insertSuggestion(UserSuggestion userSuggestion);

    List<UserSuggestion> selectSuggestions();
}
