package com.epam.spring.homework5.controller.api;

import com.epam.spring.homework5.controller.dto.TariffDTO;
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
import java.util.List;

@Api("Tariff management API")
@RequestMapping("api/v1")
public interface TariffAPI {
    @ApiImplicitParams(
            @ApiImplicitParam(name = "body",
                    paramType = "body",
                    required = true,
                    value = "Tariff to be created")
    )
    @ApiOperation("Create tariff")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/tariff")
    TariffDTO createTariff(@RequestBody @Validated(OnCreate.class) TariffDTO tariffDTO);

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
    @ApiOperation("Get page of sorted tariffs")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tariff")
    Page<TariffDTO> getSortedPagedTariffs(@RequestParam(defaultValue = "0")
                                      @Min(value = 0, message = "{tariffApi.getSortedPagedTariffs.page.min}")
                                              int page,
                                          @RequestParam(defaultValue = "5")
                                      @Min(value = 0, message = "{tariffApi.getSortedPagedTariffs.size.min}")
                                              int size,
                                          @RequestParam(defaultValue = "id")
                                      @Pattern(regexp = "id|name_en|service",
                                              message = "{tariffApi.getSortedPagedTariffs.sortBy.pattern}")
                                              String sortBy,
                                          @RequestParam(defaultValue = "asc")
                                      @Pattern(regexp = "asc|desc",
                                              message = "{tariffApi.getSortedPagedTariffs.order.pattern}")
                                              String order);

    @ApiOperation("Delete tariff")
    @DeleteMapping("/tariff/{tariffId}")
    ResponseEntity<Void> deleteTariff(@PathVariable int tariffId);
}
