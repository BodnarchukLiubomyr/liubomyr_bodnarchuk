package com.epam.spring.homework5.controller;

import com.epam.spring.homework5.controller.api.UserSuggestionAPI;
import com.epam.spring.homework5.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework5.service.UserSuggestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserSuggestionController implements UserSuggestionAPI {

    private final UserSuggestionService userSuggestionService;

    @Override
    public UserSuggestionDTO createSuggestion(UserSuggestionDTO userSuggestionDTO) {
        log.info("accepted request to create suggestion with name:{}", userSuggestionDTO.getName_en());
        return userSuggestionService.create(userSuggestionDTO);
    }

    @Override
    public Page<UserSuggestionDTO> getSortedPagedSuggestion(int page, int size, String sortBy, String order) {
        log.info("accepted request to get users` suggestions");
        return userSuggestionService.getAll(page, size, sortBy, order);
    }


}
