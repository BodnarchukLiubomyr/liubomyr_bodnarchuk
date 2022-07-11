package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Service;
import com.epam.spring.homework3.service.model.Tariff;
import com.epam.spring.homework3.service.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ServiceRepositoryImpl implements ServiceRepository {

    private int id;
    private final List<Service> services  = new ArrayList<>();

    @Override
    public Service insertService(Service service) {
        id++;
        service.setId(id);
        services.add(service);
        log.info("successfully created service with id:{}", service.getId());
        return (Service) services;
    }

    @Override
    public Service selectService(int id) {
        Service service = services.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (service != null){
            log.info("service with this id is found: {}", service.getId());
        }
        else {
            log.info("service with this id doesn't exist: {}", id);
        }
        return service;
    }

    @Override
    public List<Service> selectServices() {
        log.info("successfully received services");
        return new ArrayList<>(services);
    }

    @Override
    public void deleteService(int id) {
        services.removeIf(c->c.getId() == id);
        log.info("service is deleted with this id:{}",id);
    }


}
