package com.epam.spring.homework4.controller.api;

import com.epam.spring.homework4.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("User suggestion management API")
@RequestMapping("api/v1")
public interface UserSuggestionAPI {

    @ApiImplicitParams(
            @ApiImplicitParam(name = "body",
                    paramType = "body",
                    required = true,
                    value = "User suggestion to be created")
    )
    @ApiOperation("Create user suggestion")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/userSuggestion")
    UserSuggestionDTO createSuggestion(@RequestBody @Validated(OnCreate.class) UserSuggestionDTO userSuggestionDTO);

    @ApiOperation("Find all suggestions")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/userSuggestion")
    List<UserSuggestionDTO> getAllSuggestions();
}
