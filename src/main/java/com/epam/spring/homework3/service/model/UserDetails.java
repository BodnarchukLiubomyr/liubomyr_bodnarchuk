package com.epam.spring.homework3.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetails {
    private int id;
    private String firstnameEn;
    private String lastnameEn;
    private String firstnameUa;
    private String lastnameUa;
    private String email;
    private String phone;
}
