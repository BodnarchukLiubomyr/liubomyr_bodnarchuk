package com.epam.spring.homework5.controller.dto;

import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class UserDetailsDTO {
    int id;

    @NotNull(message = "{userDetails.firstnameEn.notNull}", groups = OnCreate.class)
    String firstnameEn;

    @NotNull(message = "{userDetails.lastnameEn.notNull}", groups = OnCreate.class)
    String lastnameEn;

    @Pattern(message = "{user.email.pattern}",
            regexp = "^(?=[a-zA-Z0-9._@%-]{6,255}$)[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}$")
    @NotNull(message = "{userDetails.email.notNull}", groups = OnCreate.class)
    String email;

    @NotNull(message = "{userDetails.phone.notNull}", groups = OnCreate.class)
    String phone;
}
