package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.service.UserSuggestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserSuggestionController {

    private UserSuggestionService userSuggestionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/userSuggestion")
    public UserSuggestionDTO createSuggestion(@RequestBody @Validated(OnCreate.class) UserSuggestionDTO userSuggestionDTO) {
        log.info("accepted request to create suggestion with name:{}", userSuggestionDTO.getName_en());
        return userSuggestionService.create(userSuggestionDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/userSuggestion")
    public List<UserSuggestionDTO> getAllSuggestions() {
        log.info("accepted request to get all suggestions");
        return userSuggestionService.getAll();
    }
}
