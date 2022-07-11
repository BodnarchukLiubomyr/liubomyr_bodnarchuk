package com.epam.spring.homework3.service.model;

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
