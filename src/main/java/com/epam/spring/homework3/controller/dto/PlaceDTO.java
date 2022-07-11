package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDTO {
    private int id;
    private String street;
    private String district;
    private String city;
}

