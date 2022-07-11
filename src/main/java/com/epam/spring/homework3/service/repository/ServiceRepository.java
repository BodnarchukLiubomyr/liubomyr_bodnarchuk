package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.Service;

import java.util.List;

public interface ServiceRepository {
    Service insertService(Service service);

    Service selectService(int id);

    List<Service> selectServices();

    void deleteService(int id);
}
