package com.epam.spring.homework5.controller.api;

import com.epam.spring.homework5.controller.dto.PlaceDTO;
import com.epam.spring.homework5.controller.dto.validation.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api("Place management API")
@RequestMapping("api/v1")
public interface PlaceAPI {
    @ApiOperation("Find user address")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/place/{placeId}")
    PlaceDTO findPlace(@PathVariable int placeId);

    @ApiImplicitParams(
            @ApiImplicitParam(name = "body",
                    paramType = "body",
                    required = true,
                    value = "Place to be updated")
    )
    @ApiOperation("Update place")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/place")
    PlaceDTO updatePlace(@RequestBody @Validated(OnUpdate.class) PlaceDTO placeDTO);
}
