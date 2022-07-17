package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.api.TariffAPI;
import com.epam.spring.homework4.controller.dto.TariffDTO;
import com.epam.spring.homework4.controller.dto.validation.group.OnCreate;
import com.epam.spring.homework4.service.TariffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TariffController implements TariffAPI {

    private final TariffService tariffService;

    @Override
    public TariffDTO createTariff(TariffDTO tariffDTO) {
        log.info("accepted request to create tariff with name:{}", tariffDTO.getName_en());
        return tariffService.create(tariffDTO);
    }

    @Override
    public List<TariffDTO> getAllTariffs() {
        log.info("accepted request to get all tariffs");
        return tariffService.getAll();
    }

    @Override
    public ResponseEntity<Void> deleteTariff(int tariffId) {
        log.info("accepted request to delete tariff with id:{}", tariffId);
        tariffService.delete(tariffId);
        return ResponseEntity.noContent().build();
    }
}
