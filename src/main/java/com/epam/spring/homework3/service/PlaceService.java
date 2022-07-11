package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.PlaceDTO;

public interface PlaceService {

    PlaceDTO update(PlaceDTO placeDTO);

    PlaceDTO find(int placeId);
}
