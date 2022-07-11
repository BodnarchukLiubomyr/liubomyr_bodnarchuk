package com.epam.spring.homework3.controller.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletDTO {
    private int id;
    private BigDecimal funds;
    private BigDecimal change;
}
