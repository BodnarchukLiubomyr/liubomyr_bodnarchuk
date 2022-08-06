package com.epam.spring.homework5.service.impl;

import com.epam.spring.homework5.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework5.service.UserSuggestionService;
import com.epam.spring.homework5.service.exception.UserSuggestionAlreadyExistsException;
import com.epam.spring.homework5.service.mapper.UserSuggestionMapper;
import com.epam.spring.homework5.service.model.UserSuggestion;
import com.epam.spring.homework5.service.repository.UserSuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserSuggestionServiceImpl implements UserSuggestionService {

    private UserSuggestionRepository userSuggestionRepository;

    @Override
    @Transactional
    public Page<UserSuggestionDTO> getAll(int page, int size, String sortBy, String order) {
        log.info("reading users' suggestions");
        Pageable pageable = PageRequest.of(page, size,
                order.equals("desc") ? Sort.by(sortBy).descending()
                        : Sort.by(sortBy).ascending());
        Page<UserSuggestionDTO> userSuggestionDTOS = userSuggestionRepository.findAll(pageable)
                .map(UserSuggestionMapper.INSTANCE::mapUserSuggestionDto);
        log.info("users' suggestions were successfully read");
        return userSuggestionDTOS;
    }

    @Override
    @Transactional
    public UserSuggestionDTO create(UserSuggestionDTO userSuggestionDTO) {
        log.info("creating user's suggestion with name:{}", userSuggestionDTO.getName_en());
        if (userSuggestionRepository.existsByName(userSuggestionDTO.getName_en())) {
            throw new UserSuggestionAlreadyExistsException();
        }
        UserSuggestion userSuggestion = userSuggestionRepository
                .save(UserSuggestionMapper.INSTANCE.mapUserSuggestion(userSuggestionDTO));
        return UserSuggestionMapper.INSTANCE.mapUserSuggestionDto(userSuggestion);
    }
}
