package com.epam.spring.homework4.service.model;

import com.epam.spring.homework4.service.model.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String login;
    private String password;
    private Role role;
    private UserDetails details;
    private Place place;
    private Wallet wallet;
}
