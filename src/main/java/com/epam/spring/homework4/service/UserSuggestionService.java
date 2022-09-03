package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.UserSuggestionDTO;

import java.util.List;

public interface UserSuggestionService {
    List<UserSuggestionDTO> getAll();

    UserSuggestionDTO create(UserSuggestionDTO userSuggestionDTO);
}
