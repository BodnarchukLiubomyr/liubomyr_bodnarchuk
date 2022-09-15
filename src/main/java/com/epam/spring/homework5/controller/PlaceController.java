package com.epam.spring.homework5.controller;

import com.epam.spring.homework5.controller.api.PlaceAPI;
import com.epam.spring.homework5.controller.dto.PlaceDTO;
import com.epam.spring.homework5.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

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
