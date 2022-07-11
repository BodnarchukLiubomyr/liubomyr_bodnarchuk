package com.epam.spring.homework3.service.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSuggestion {
    private int id;
    private String name_en;
    private int time;
    private BigDecimal price;
    private String description;
    private Service service;
}
