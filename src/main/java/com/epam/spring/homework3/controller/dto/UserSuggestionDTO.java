package com.epam.spring.homework3.controller.dto;

import java.math.BigDecimal;

import com.epam.spring.homework3.service.model.Service;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSuggestionDTO {
    private int id;
    private String name_en;
    private int time;
    private BigDecimal price;
    private String description;
    private Service service;
}
