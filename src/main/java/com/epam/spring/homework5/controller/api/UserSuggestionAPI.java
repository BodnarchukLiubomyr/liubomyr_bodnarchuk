package com.epam.spring.homework5.controller.api;

import com.epam.spring.homework5.controller.dto.UserSuggestionDTO;
import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

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

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",
                    paramType = "query",
                    value = "Page number to be read"),
            @ApiImplicitParam(name = "size",
                    paramType = "query",
                    value = "Page size to be read"
            ),
            @ApiImplicitParam(name = "sortBy",
                    paramType = "query",
                    value = "Field that will be used for sorting"),
            @ApiImplicitParam(name = "order",
                    paramType = "query",
                    value = "Order of sorting")}
    )
    @ApiOperation("Get page of sorted users` suggestion")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/userSuggestion")
    Page<UserSuggestionDTO> getSortedPagedSuggestion(@RequestParam(defaultValue = "0")
                                      @Min(value = 0, message = "{userSuggestionApi.getSortedPagedUserSuggestions.page.min}")
                                              int page,
                                                     @RequestParam(defaultValue = "5")
                                      @Min(value = 0, message = "{userSuggestionApi.getSortedPagedUserSuggestions.size.min}")
                                              int size,
                                                     @RequestParam(defaultValue = "id")
                                      @Pattern(regexp = "id|name_en|service",
                                              message = "{userSuggestionApi.getSortedPagedUserSuggestions.sortBy.pattern}")
                                              String sortBy,
                                                     @RequestParam(defaultValue = "asc")
                                      @Pattern(regexp = "asc|desc",
                                              message = "{userSuggestionApi.getSortedPagedUserSuggestions.order.pattern}")
                                              String order);
}
