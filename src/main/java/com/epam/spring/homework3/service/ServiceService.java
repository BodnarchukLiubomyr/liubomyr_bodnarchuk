package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.ServiceDTO;

import java.util.List;

public interface ServiceService {
    List<ServiceDTO> getAll();

    ServiceDTO create(ServiceDTO serviceDTO);

    void delete(int serviceId);
}
