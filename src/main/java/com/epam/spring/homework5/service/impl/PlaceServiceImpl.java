package com.epam.spring.homework5.service.impl;

import com.epam.spring.homework5.controller.dto.PlaceDTO;
import com.epam.spring.homework5.service.PlaceService;
import com.epam.spring.homework5.service.exception.PlaceAlreadyExistsException;
import com.epam.spring.homework5.service.exception.PlaceNotFoundException;
import com.epam.spring.homework5.service.mapper.PlaceMapper;
import com.epam.spring.homework5.service.model.Place;
import com.epam.spring.homework5.service.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    @Transactional
    public PlaceDTO update(PlaceDTO placeDTO) {
        log.info("updating place with id:{}", placeDTO.getId());
        Optional<Place> placeOptional = placeRepository.findById(placeDTO.getId());
        if (placeOptional.isEmpty()) {
            throw new PlaceNotFoundException();
        }
        if (placeRepository.existsByIdIsNot(placeDTO.getId())){
            throw new PlaceAlreadyExistsException();
        }
        Place place = placeOptional.get();
        PlaceMapper.INSTANCE.mapPresentFields(place, PlaceMapper.INSTANCE.mapPlace(placeDTO));
        Place updatedPlace = placeRepository.save(place);
        log.info("place with id:{} was successfully updated", updatedPlace.getId());
        return PlaceMapper.INSTANCE.mapPlaceDto(updatedPlace);
    }

    @Override
    @Transactional
    public PlaceDTO find(int placeId) {
        log.info("finding place with id:{}", placeId);
        Optional<Place> optionalPlace = placeRepository.findById(placeId);
        if (optionalPlace.isEmpty()) {
            throw new PlaceNotFoundException();
        }
        return PlaceMapper.INSTANCE.mapPlaceDto(optionalPlace.get());
    }
}
