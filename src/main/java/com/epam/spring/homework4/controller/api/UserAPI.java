package com.epam.spring.homework4.controller.api;

import com.epam.spring.homework4.controller.dto.UserDTO;
import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("User management API")
@RequestMapping("api/v1")
public interface UserAPI {
    @ApiImplicitParams(
            @ApiImplicitParam(name = "body",
                    paramType = "body",
                    required = true,
                    value = "User to be created")
    )
    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDTO);

    @ApiOperation("Find all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    List<UserDTO> getAllUsers();

    @ApiOperation("Find user by login")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{login}")
    UserDTO getUser(@PathVariable String login);
}
