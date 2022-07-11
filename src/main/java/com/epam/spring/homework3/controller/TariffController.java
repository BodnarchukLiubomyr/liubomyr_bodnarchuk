package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.TariffDTO;
import com.epam.spring.homework3.service.TariffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/tariff")
    public TariffDTO createTariff(@RequestBody TariffDTO tariffDTO) {
        log.info("accepted request to create tariff with name:{}", tariffDTO.getName_en());
        return tariffService.create(tariffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tariff")
    public List<TariffDTO> getAllTariffs() {
        log.info("accepted request to get all tariffs");
        return tariffService.getAll();
    }

    @DeleteMapping("/tariff/{tariffId}")
    public ResponseEntity<Void> deleteTariff(@PathVariable int tariffId) {
        log.info("accepted request to delete tariff with id:{}", tariffId);
        tariffService.delete(tariffId);
        return ResponseEntity.noContent().build();
    }
}
