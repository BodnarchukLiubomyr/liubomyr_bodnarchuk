package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.ServiceDTO;
import com.epam.spring.homework3.service.ServiceService;
import com.epam.spring.homework3.service.exception.NotFoundException;
import com.epam.spring.homework3.service.mapper.ServiceMapper;
import com.epam.spring.homework3.service.model.Service;
import com.epam.spring.homework3.service.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<ServiceDTO> getAll() {
        log.info("receiving all services");
        return serviceRepository.selectServices().stream()
                .map(ServiceMapper.INSTANCE::mapServiceDto)
                .sorted(Comparator.comparing(ServiceDTO::getId)).collect(Collectors.toList());
    }

    @Override
    public ServiceDTO create(ServiceDTO serviceDTO) {
        log.info("creating service with name:{}", serviceDTO.getService_en());
        Service service = ServiceMapper.INSTANCE.mapService(serviceDTO);
        return ServiceMapper.INSTANCE.mapServiceDto(serviceRepository.insertService(service));
    }

    @Override
    public void delete(int serviceId) {
        log.info("deleting service with id:{}", serviceId);
        if (serviceRepository.selectService(serviceId) == null) {
            throw new NotFoundException("No service with id=" + serviceId + " was found to delete.");
        }
        serviceRepository.deleteService(serviceId);
    }
}
