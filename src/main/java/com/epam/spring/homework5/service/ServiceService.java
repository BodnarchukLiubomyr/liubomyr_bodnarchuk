package com.epam.spring.homework5.service;

import com.epam.spring.homework5.controller.dto.ServiceDTO;
import org.springframework.data.domain.Page;

public interface ServiceService {
    Page<ServiceDTO> getAll(int page, int size, String sortBy, String order);

    ServiceDTO create(ServiceDTO serviceDTO);

    void delete(int serviceId);
}
