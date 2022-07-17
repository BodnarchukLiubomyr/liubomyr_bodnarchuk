package com.epam.spring.homework4.controller.api;

import com.epam.spring.homework4.controller.dto.ServiceDTO;
import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Service management API")
@RequestMapping("api/v1")
public interface ServiceAPI {
    @ApiImplicitParams(
            @ApiImplicitParam(name = "body",
                    paramType = "body",
                    required = true,
                    value = "Service to be created")
    )
    @ApiOperation("Create service")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/service")
    ServiceDTO createService(@RequestBody @Validated(OnCreate.class) ServiceDTO serviceDTO);

    @ApiOperation("Find all services")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/service")
    List<ServiceDTO> getAllServices();

    @ApiOperation("Delete service")
    @GetMapping("/service/{serviceId}")
    ResponseEntity<Void> deleteService(@PathVariable int serviceId);

}
