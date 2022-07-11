package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.ServiceDTO;
import com.epam.spring.homework3.service.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/service")
    public ServiceDTO createService(@RequestBody ServiceDTO serviceDTO) {
        log.info("accepted request to create service with name:{}", serviceDTO.getService_en());
        return serviceService.create(serviceDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/service")
    public List<ServiceDTO> getAllServices() {
        log.info("accepted request to get all services");
        return serviceService.getAll();
    }

    @DeleteMapping("/service/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable int serviceId) {
        log.info("accepted request to delete service with id:{}", serviceId);
        serviceService.delete(serviceId);
        return ResponseEntity.noContent().build();
    }
}
