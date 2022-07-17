package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.api.PlaceAPI;
import com.epam.spring.homework4.controller.dto.PlaceDTO;
import com.epam.spring.homework4.controller.dto.validation.group.OnUpdate;
import com.epam.spring.homework4.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PlaceController implements PlaceAPI {
    private final PlaceService placeService;

    @Override
    public PlaceDTO findPlace(int placeId) {
        log.info("accepted request to find place with id:{}", placeId);
        return placeService.find(placeId);
    }

    @Override
    public PlaceDTO updatePlace(PlaceDTO placeDTO) {
        log.info("accepted request to update place with id:{}", placeDTO.getId());
        return placeService.update(placeDTO);
    }
}
