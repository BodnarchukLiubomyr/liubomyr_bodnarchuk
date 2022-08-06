package com.epam.spring.homework5.service;

import com.epam.spring.homework5.controller.dto.ServiceDTO;
import com.epam.spring.homework5.controller.dto.UserSuggestionDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserSuggestionService {
    Page<UserSuggestionDTO> getAll(int page, int size, String sortBy, String order);

    UserSuggestionDTO create(UserSuggestionDTO userSuggestionDTO);
}
