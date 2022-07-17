package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.api.UserSuggestionAPI;
import com.epam.spring.homework4.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework4.service.UserSuggestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserSuggestionController implements UserSuggestionAPI {

    private UserSuggestionService userSuggestionService;

    @Override
    public UserSuggestionDTO createSuggestion(UserSuggestionDTO userSuggestionDTO) {
        log.info("accepted request to create suggestion with name:{}", userSuggestionDTO.getName_en());
        return userSuggestionService.create(userSuggestionDTO);
    }

    @Override
    public List<UserSuggestionDTO> getAllSuggestions() {
        log.info("accepted request to get all suggestions");
        return userSuggestionService.getAll();
    }
}
