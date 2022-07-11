package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.UserSuggestionDTO;

import java.util.List;

public interface UserSuggestionService {
    List<UserSuggestionDTO> getAll();

    UserSuggestionDTO create(UserSuggestionDTO userSuggestionDTO);
}
