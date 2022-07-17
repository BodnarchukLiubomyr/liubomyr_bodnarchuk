package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.PlaceDTO;

public interface PlaceService {

    PlaceDTO update(PlaceDTO placeDTO);

    PlaceDTO find(int placeId);
}
