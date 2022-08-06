package com.epam.spring.homework5.service;

import com.epam.spring.homework5.controller.dto.PlaceDTO;

public interface PlaceService {

    PlaceDTO update(PlaceDTO placeDTO);

    PlaceDTO find(int placeId);
}
