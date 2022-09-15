package com.epam.spring.homework5.controller.api;

import com.epam.spring.homework5.controller.dto.ServiceDTO;
import com.epam.spring.homework5.controller.dto.validation.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

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

    @ApiOperation("Get page of sorted services")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/service")
    Page<ServiceDTO> getSortedPagedServices(@RequestParam(defaultValue = "0")
                                      @Min(value = 0, message = "{serviceApi.getSortedPagedServices.page.min}")
                                              int page,
                                      @RequestParam(defaultValue = "5")
                                      @Min(value = 0, message = "{serviceApi.getSortedPagedServices.size.min}")
                                              int size,
                                      @RequestParam(defaultValue = "id")
                                      @Pattern(regexp = "id|service_en",
                                              message = "{serviceApi.getSortedPagedServices.sortBy.pattern}")
                                              String sortBy,
                                      @RequestParam(defaultValue = "asc")
                                      @Pattern(regexp = "asc|desc",
                                              message = "{serviceApi.getSortedPagedServices.order.pattern}")
                                              String order);

    @ApiOperation("Delete service")
    @GetMapping("/service/{serviceId}")
    ResponseEntity<Void> deleteService(@PathVariable int serviceId);

}
