package com.epam.spring.homework5.controller.dto;

import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework5.controller.dto.validation.group.OnUpdate;
import com.epam.spring.homework5.service.model.Service;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Builder
public class TariffDTO {
    @Null(message = "{tariff.id.null}", groups = OnCreate.class)
    @NotNull(message = "{tariff.id.notNull}", groups = OnUpdate.class)
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
    private ServiceDTO service;
}
