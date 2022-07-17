package com.epam.spring.homework4.service.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tariff{
    private int id;
    private String name_en;
    private int time;
    private BigDecimal price;
    private String description;
    private Service service;

}
