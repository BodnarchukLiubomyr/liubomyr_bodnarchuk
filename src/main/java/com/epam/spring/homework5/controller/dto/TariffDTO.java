package com.epam.spring.homework5.controller.dto;

import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework5.service.model.Service;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class TariffDTO {
    int id;

    @NotNull(message = "{tariff.name_en.notNull}", groups = OnCreate.class)
    String name_en;

    @NotNull(message = "{tariff.time.notNull}", groups = OnCreate.class)
    int time;

    @NotNull(message = "{tariff.price.notNull}", groups = OnCreate.class)
    BigDecimal price;

    @NotNull(message = "{tariff.description.notNull}", groups = OnCreate.class)
    String description;

    @NotNull(message = "{tariff.service.notNull}",groups = OnCreate.class)
    Service service;
}
