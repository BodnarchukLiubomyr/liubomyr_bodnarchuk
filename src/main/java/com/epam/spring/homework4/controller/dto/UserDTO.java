package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.controller.dto.validation.EnumValidator;
import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.controller.dto.validation.group.OnUpdate;
import com.epam.spring.homework4.service.model.Place;
import com.epam.spring.homework4.service.model.UserDetails;
import com.epam.spring.homework4.service.model.Wallet;
import com.epam.spring.homework4.service.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    int id;

    @NotNull(message = "{user.login.notNull}", groups = OnCreate.class)
    String login;

    @Pattern(message = "{user.password.pattern}",
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,32}$")
    @NotNull(message = "{user.password.notNull}", groups = OnCreate.class)
    String password;

    @Pattern(message = "{user.repeatPassword.pattern}",
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,32}$")
    @NotNull(message = "{user.repeatPassword.notNull}", groups = OnCreate.class)
    String repeatPassword;

    @EnumValidator(name = "{user.role.name}",enumClass = Role.class)
    @NotNull(message = "{user.role.notNull}", groups = OnCreate.class)
    String role;

    @NotNull(message = "{user.details.notNull}", groups = OnCreate.class)
    UserDetails details;

    @NotNull(message = "{user.place.notNull}", groups = OnCreate.class)
    @Null(message = "{user.place.null}", groups = OnUpdate.class)
    Place place;

    @NotNull(message = "{user.wallet.notNull}", groups = OnCreate.class)
    @Null(message = "{user.wallet.null}", groups = OnUpdate.class)
    Wallet wallet;
}
