package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.UserSuggestion;

import java.util.List;

public interface UserSuggestionRepository {
    UserSuggestion insertSuggestion(UserSuggestion userSuggestion);

    List<UserSuggestion> selectSuggestions();
}
