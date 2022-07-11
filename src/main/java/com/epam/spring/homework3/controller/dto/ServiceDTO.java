package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceDTO {
    int id;
    String service_en;
}
