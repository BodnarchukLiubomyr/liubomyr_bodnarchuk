package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.PlaceDTO;
import com.epam.spring.homework4.service.PlaceService;
import com.epam.spring.homework4.service.exception.NotFoundException;
import com.epam.spring.homework4.service.exception.PlaceNotFoundException;
import com.epam.spring.homework4.service.mapper.PlaceMapper;
import com.epam.spring.homework4.service.model.Place;
import com.epam.spring.homework4.service.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlaceServiceImpl implements PlaceService {

    private PlaceRepository placeRepository;

    @Override
    public PlaceDTO update(PlaceDTO placeDTO) {
        Place place = PlaceMapper.INSTANCE.mapPlace(placeDTO);
        log.info("updating place with id:{}", placeDTO.getId());
        if (placeRepository.updatePlace(place) == null) {
            throw new PlaceNotFoundException();
        }
        return PlaceMapper.INSTANCE.mapPlaceDto(placeRepository.updatePlace(place));
    }

    @Override
    public PlaceDTO find(int placeId) {
        log.info("deleting place with id:{}", placeId);
        if (placeRepository.selectPlace(placeId) == null) {
            throw new PlaceNotFoundException();
        }
        return PlaceMapper.INSTANCE.mapPlaceDto(placeRepository.selectPlace(placeId));
    }
}
