package com.epam.spring.homework4.service.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Wallet {
    private int id;
    private BigDecimal funds;
    private BigDecimal change;
}
