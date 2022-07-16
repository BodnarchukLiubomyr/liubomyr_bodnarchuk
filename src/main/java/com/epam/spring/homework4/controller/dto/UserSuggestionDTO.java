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
    int id;

    @NotNull(message = "{userSuggestion.name_en.notNull}", groups = OnCreate.class)
    String name_en;

    @NotNull(message = "{userSuggestion.time.notNull}", groups = OnCreate.class)
    int time;

    @NotNull(message = "{userSuggestion.price.notNull}", groups = OnCreate.class)
    BigDecimal price;

    @NotNull(message = "{userSuggestion.description.notNull}", groups = OnCreate.class)
    String description;

    @NotNull(message = "{userSuggestion.service.notNull}", groups = OnCreate.class)
    Service service;
}
