package com.epam.spring.homework3.controller.dto;

import com.epam.spring.homework3.service.model.Place;
import com.epam.spring.homework3.service.model.UserDetails;
import com.epam.spring.homework3.service.model.Wallet;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private int id;
    private String login;
    private String password;
    private String repeatPassword;
    private String role;
    private UserDetails details;
    private Place place;
    private Wallet wallet;
}
