package com.epam.spring.homework5.service.mapper;

import com.epam.spring.homework5.controller.dto.ServiceDTO;
import com.epam.spring.homework5.service.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceDTO mapServiceDto(Service service);

    Service mapService(ServiceDTO serviceDTO);
}
