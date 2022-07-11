package com.epam.spring.homework3.service.mapper;

import com.epam.spring.homework3.controller.dto.UserDTO;
import com.epam.spring.homework3.service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserDetailsMapper.class, PlaceMapper.class, WalletMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDTO mapUserDto(User user);

    User mapUser(UserDTO userDTO);
}
