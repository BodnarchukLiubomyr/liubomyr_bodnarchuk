package com.epam.spring.homework5.service.mapper;

import com.epam.spring.homework5.controller.dto.UserDTO;
import com.epam.spring.homework5.service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserDetailsMapper.class, PlaceMapper.class, WalletMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDTO mapUserDto(User user);

    @Mapping(target = "id", defaultValue = "0")
    User mapUser(UserDTO userDTO);
}
