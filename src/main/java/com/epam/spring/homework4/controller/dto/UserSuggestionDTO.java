package com.epam.spring.homework4.controller.dto;

import java.math.BigDecimal;

import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.service.model.Service;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserSuggestionDTO {
    private Integer id;

    @NotNull(message = "{userSuggestion.name_en.notNull}", groups = OnCreate.class)
    private String name_en;

    @NotNull(message = "{userSuggestion.time.notNull}", groups = OnCreate.class)
    private int time;

    @NotNull(message = "{userSuggestion.price.notNull}", groups = OnCreate.class)
    private BigDecimal price;

    @NotNull(message = "{userSuggestion.description.notNull}", groups = OnCreate.class)
    private String description;

    @NotNull(message = "{userSuggestion.service.notNull}", groups = OnCreate.class)
    private Service service;
}
