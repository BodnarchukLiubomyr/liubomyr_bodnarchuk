package com.epam.spring.homework5.controller.dto;

import java.math.BigDecimal;

import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework5.controller.dto.validation.group.OnUpdate;
import com.epam.spring.homework5.service.model.Service;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
public class UserSuggestionDTO {
    @Null(message = "{userSuggestion.id.null}", groups = OnCreate.class)
    @NotNull(message = "{userSuggestion.id.notNull}", groups = OnUpdate.class)
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
    private ServiceDTO service;
}
