package com.epam.spring.homework4.service.mapper;

import com.epam.spring.homework4.controller.dto.ServiceDTO;
import com.epam.spring.homework4.service.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceDTO mapServiceDto(Service service);

    Service mapService(ServiceDTO serviceDTO);
}
