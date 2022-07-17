package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.controller.dto.validation.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class ServiceDTO {
    int id;
    @NotNull(message = "{service.service_en.notNull}", groups = OnCreate.class)
    @Null(message = "{service.service_en.null}", groups = OnUpdate.class)
    String service_en;
}
