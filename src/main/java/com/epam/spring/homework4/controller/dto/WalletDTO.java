package com.epam.spring.homework4.controller.dto;

import java.math.BigDecimal;

import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.controller.dto.validation.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
public class WalletDTO {
    int id;

    @NotNull(message = "{wallet.funds.notNull}", groups = OnCreate.class)
    @Null(message = "{wallet.funds.null}", groups = OnUpdate.class)
    BigDecimal funds;

    @NotNull(message = "{wallet.change.notNull}", groups = OnCreate.class)
    @Null(message = "{wallet.change.null}", groups = OnUpdate.class)
    BigDecimal change;
}
