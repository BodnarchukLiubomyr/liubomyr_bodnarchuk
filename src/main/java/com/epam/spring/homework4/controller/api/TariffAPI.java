package com.epam.spring.homework4.controller.api;

import com.epam.spring.homework4.controller.dto.TariffDTO;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tariff")
    List<TariffDTO> getAllTariffs();

    @ApiOperation("Delete tariff")
    @DeleteMapping("/tariff/{tariffId}")
    ResponseEntity<Void> deleteTariff(@PathVariable int tariffId);
}
