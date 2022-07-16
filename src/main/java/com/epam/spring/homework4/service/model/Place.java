package com.epam.spring.homework4.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Place {
    private int id;
    private String street;
    private String district;
    private String city;
}
