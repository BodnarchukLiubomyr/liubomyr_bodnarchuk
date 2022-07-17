package com.epam.spring.homework4.service.repository;

import com.epam.spring.homework4.service.model.Place;

public interface PlaceRepository {
    Place selectPlace(int id);

    Place updatePlace(Place place);
}
