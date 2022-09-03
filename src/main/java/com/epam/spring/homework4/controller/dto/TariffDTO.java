package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.service.model.Service;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class TariffDTO {
    private Integer id;

    @NotNull(message = "{tariff.name_en.notNull}", groups = OnCreate.class)
    private String name_en;

    @NotNull(message = "{tariff.time.notNull}", groups = OnCreate.class)
    private int time;

    @NotNull(message = "{tariff.price.notNull}", groups = OnCreate.class)
    private BigDecimal price;

    @NotNull(message = "{tariff.description.notNull}", groups = OnCreate.class)
    private String description;

    @NotNull(message = "{tariff.service.notNull}",groups = OnCreate.class)
    private Service service;
}
