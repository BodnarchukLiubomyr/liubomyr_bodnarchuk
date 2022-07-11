package com.epam.spring.homework3.service.mapper;

import com.epam.spring.homework3.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework3.service.model.UserSuggestion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ServiceMapper.class})
public interface UserSuggestionMapper {
    UserSuggestionMapper INSTANCE = Mappers.getMapper(UserSuggestionMapper.class);

    UserSuggestionDTO mapUserSuggestionDto(UserSuggestion userSuggestion);

    UserSuggestion mapUserSuggestion(UserSuggestionDTO userSuggestionDTO);
}
