package com.epam.spring.homework3.controller.dto;

import com.epam.spring.homework3.service.model.Service;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TariffDTO {
    private int id;
    private String name_en;
    private int time;
    private BigDecimal price;
    private String description;
    private Service service;
}
