package com.epam.spring.homework5.controller.api;

import com.epam.spring.homework5.controller.dto.UserDTO;
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
    @ApiOperation("Get page of sorted users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    Page<UserDTO> getSortedPagedUsers(@RequestParam(defaultValue = "0")
                                      @Min(value = 0, message = "{userApi.getSortedPagedUsers.page.min}")
                                              int page,
                                      @RequestParam(defaultValue = "5")
                                      @Min(value = 0, message = "{userApi.getSortedPagedUsers.size.min}")
                                              int size,
                                      @RequestParam(defaultValue = "id")
                                      @Pattern(regexp = "id|login",
                                              message = "{userApi.getSortedPagedUsers.sortBy.pattern}")
                                              String sortBy,
                                      @RequestParam(defaultValue = "asc")
                                      @Pattern(regexp = "asc|desc",
                                              message = "{userApi.getSortedPagedUsers.order.pattern}")
                                              String order);

    @ApiOperation("Find user by login")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{login}")
    UserDTO getUser(@PathVariable String login);
}
