package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework3.service.UserSuggestionService;
import com.epam.spring.homework3.service.mapper.UserSuggestionMapper;
import com.epam.spring.homework3.service.model.UserSuggestion;
import com.epam.spring.homework3.service.repository.UserSuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserSuggestionServiceImpl implements UserSuggestionService {

    private UserSuggestionRepository userSuggestionRepository;

    @Override
    public List<UserSuggestionDTO> getAll() {
        log.info("receiving all users` suggestions ");
        return userSuggestionRepository.selectSuggestions().stream()
                .map(UserSuggestionMapper.INSTANCE::mapUserSuggestionDto)
                .sorted(Comparator.comparing(UserSuggestionDTO::getId)).collect(Collectors.toList());
    }

    @Override
    public UserSuggestionDTO create(UserSuggestionDTO userSuggestionDTO) {
        log.info("creating users` suggestions with name:{}", userSuggestionDTO.getName_en());
        UserSuggestion userSuggestion = UserSuggestionMapper.INSTANCE.mapUserSuggestion(userSuggestionDTO);
        return UserSuggestionMapper.INSTANCE.mapUserSuggestionDto(userSuggestionRepository.insertSuggestion(userSuggestion));
    }
}
