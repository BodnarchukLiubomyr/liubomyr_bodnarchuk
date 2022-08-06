package com.epam.spring.homework5.controller.dto;

import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework5.controller.dto.validation.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
public class PlaceDTO {
    @Null(message = "{place.id.null}", groups = OnCreate.class)
    @NotNull(message = "{place.id.notNull}", groups = OnUpdate.class)
    Integer id;

    @NotNull(message = "{place.street.notNull}", groups = OnCreate.class)
    @Null(message = "{place.street.null}", groups = OnUpdate.class)
    private String street;

    @NotNull(message = "{place.district.notNull}", groups = OnCreate.class)
    @Null(message = "{place.district.null}", groups = OnUpdate.class)
    private String district;

    @NotNull(message = "{place.city.notNull}", groups = OnCreate.class)
    @Null(message = "{place.city.null}", groups = OnUpdate.class)
    private String city;
}

