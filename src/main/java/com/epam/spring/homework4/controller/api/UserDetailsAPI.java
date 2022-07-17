package com.epam.spring.homework4.controller.api;

import com.epam.spring.homework4.controller.dto.UserDetailsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api("User details management API")
@RequestMapping("api/v1")
public interface UserDetailsAPI {
    @ApiOperation("Find user's details")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/userDetails/{userDetailsId}")
    UserDetailsDTO getUserDetails(@PathVariable int userDetailsId);
}
