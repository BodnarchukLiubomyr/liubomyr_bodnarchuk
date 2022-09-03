package com.epam.spring.homework4.service.mapper;

import com.epam.spring.homework4.controller.dto.UserDetailsDTO;
import com.epam.spring.homework4.service.model.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailsMapper {
    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

    UserDetailsDTO mapUserDetailsDto(UserDetails userDetails);

    UserDetails mapUserDetails(UserDetailsDTO userDetailsDTO);
}
