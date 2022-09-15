package com.epam.spring.homework5.service.impl;

import com.epam.spring.homework5.controller.dto.ServiceDTO;
import com.epam.spring.homework5.service.ServiceService;
import com.epam.spring.homework5.service.exception.ServiceAlreadyExistsException;
import com.epam.spring.homework5.service.exception.ServiceNotFoundException;
import com.epam.spring.homework5.service.mapper.ServiceMapper;
import com.epam.spring.homework5.service.model.Service;
import com.epam.spring.homework5.service.repository.ServiceRepository;
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
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    @Transactional
    public Page<ServiceDTO> getAll(int page, int size, String sortBy, String order) {
        log.info("get services");
        Pageable pageable = PageRequest.of(page, size,
                order.equals("desc") ? Sort.by(sortBy).descending()
                        : Sort.by(sortBy).ascending());
        Page<ServiceDTO> serviceDTOS = serviceRepository.findAll(pageable)
                .map(ServiceMapper.INSTANCE::mapServiceDto);
        log.info("services were successfully got");
        return serviceDTOS;
    }

    @Override
    @Transactional
    public ServiceDTO create(ServiceDTO serviceDTO) {
        log.info("creating service with name:{}", serviceDTO.getService_en());
        if (serviceRepository.existsByService(serviceDTO.getService_en())) {
            throw new ServiceAlreadyExistsException();
        }
        Service service = serviceRepository.save(ServiceMapper.INSTANCE.mapService(serviceDTO));
        return ServiceMapper.INSTANCE.mapServiceDto(service);
    }

    @Override
    @Transactional
    public void delete(int serviceId) {
        log.info("deleting service with id:{}", serviceId);
        if (serviceRepository.existsById(serviceId)) {
            throw new ServiceNotFoundException();
        }
        serviceRepository.deleteById(serviceId);
    }
}
