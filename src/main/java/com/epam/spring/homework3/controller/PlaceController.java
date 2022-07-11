package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.PlaceDTO;
import com.epam.spring.homework3.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/place/{placeId}")
    public PlaceDTO findPlace(@PathVariable int placeId) {
        log.info("accepted request to find place with id:{}", placeId);
        return placeService.find(placeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/place")
    public PlaceDTO updatePlace(PlaceDTO placeDTO) {
        log.info("accepted request to update place with id:{}", placeDTO.getId());
        return placeService.update(placeDTO);
    }
}
