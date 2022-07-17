package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.api.ServiceAPI;
import com.epam.spring.homework4.controller.dto.ServiceDTO;
import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.service.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ServiceController implements ServiceAPI {

    private final ServiceService serviceService;

    @Override
    public ServiceDTO createService(ServiceDTO serviceDTO) {
        log.info("accepted request to create service with name:{}", serviceDTO.getService_en());
        return serviceService.create(serviceDTO);
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        log.info("accepted request to get all services");
        return serviceService.getAll();
    }

    @Override
    public ResponseEntity<Void> deleteService(int serviceId) {
        log.info("accepted request to delete service with id:{}", serviceId);
        serviceService.delete(serviceId);
        return ResponseEntity.noContent().build();
    }
}
