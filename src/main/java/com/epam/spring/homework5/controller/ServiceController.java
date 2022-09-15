package com.epam.spring.homework5.controller;

import com.epam.spring.homework5.controller.api.ServiceAPI;
import com.epam.spring.homework5.controller.dto.ServiceDTO;
import com.epam.spring.homework5.service.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<ServiceDTO> getSortedPagedServices(int page, int size, String sortBy, String order) {
        log.info("accepted request to get services");
        return serviceService.getAll(page, size, sortBy, order);
    }


    @Override
    public ResponseEntity<Void> deleteService(int serviceId) {
        log.info("accepted request to delete service with id:{}", serviceId);
        serviceService.delete(serviceId);
        return ResponseEntity.noContent().build();
    }
}
