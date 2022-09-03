package com.epam.spring.homework5.service.mapper;

import com.epam.spring.homework5.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework5.service.model.UserSuggestion;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ServiceMapper.class},nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserSuggestionMapper {
    UserSuggestionMapper INSTANCE = Mappers.getMapper(UserSuggestionMapper.class);

    UserSuggestionDTO mapUserSuggestionDto(UserSuggestion userSuggestion);

    UserSuggestion mapUserSuggestion(UserSuggestionDTO userSuggestionDTO);
}
