package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.Place;

public interface PlaceRepository {
    Place selectPlace(int id);

    Place updatePlace(Place place);
}
