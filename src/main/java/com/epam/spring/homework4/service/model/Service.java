package com.epam.spring.homework4.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Service {
    private int id;
    private String service_en;
}
