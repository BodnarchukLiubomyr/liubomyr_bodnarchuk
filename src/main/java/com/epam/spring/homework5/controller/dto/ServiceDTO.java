package com.epam.spring.homework5.controller.dto;

import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework5.controller.dto.validation.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
public class ServiceDTO {
    @Null(message = "{service.id.null}", groups = OnCreate.class)
    @NotNull(message = "{service.id.notNull}", groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "{service.service_en.notNull}", groups = OnCreate.class)
    @Null(message = "{service.service_en.null}", groups = OnUpdate.class)
    private String service_en;
}
