package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Place;
import com.epam.spring.homework3.service.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlaceRepositoryImpl implements PlaceRepository {

    private int id;
    private final List<Place> places = new ArrayList<>();

    @Override
    public Place selectPlace(int id) {
        Place place = places.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (place != null) {
            log.info("place with this id is found: {}", place.getId());
        } else {
            log.info("place with this id doesn't exist: {}", id);
        }
        return place;
    }

    @Override
    public Place updatePlace(Place place) {
        int placeId = place.getId();
        Optional<Place> placeOptional = places.stream()
                .filter(a -> a.getId() == placeId)
                .findFirst();
        if (placeOptional.isPresent()) {
            place = placeOptional.get();
            place.setStreet(place.getStreet());
            place.setDistrict(place.getDistrict());
            place.setCity(place.getCity());
        }
        return place;
    }
}
