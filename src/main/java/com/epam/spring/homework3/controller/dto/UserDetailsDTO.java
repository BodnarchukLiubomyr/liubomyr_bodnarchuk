package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsDTO {
    private int id;
    private String firstnameEn;
    private String lastnameEn;
    private String firstnameUa;
    private String lastnameUa;
    private String email;
    private String phone;
}
