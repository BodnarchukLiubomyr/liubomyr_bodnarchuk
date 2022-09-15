package com.epam.spring.homework5.controller;

import com.epam.spring.homework5.controller.api.TariffAPI;
import com.epam.spring.homework5.controller.dto.TariffDTO;
import com.epam.spring.homework5.service.TariffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<TariffDTO> getSortedPagedTariffs(int page, int size, String sortBy, String order) {
        log.info("accepted request to get tariffs");
        return tariffService.getAll(page, size, sortBy, order);
    }


    @Override
    public ResponseEntity<Void> deleteTariff(int tariffId) {
        log.info("accepted request to delete tariff with id:{}", tariffId);
        tariffService.delete(tariffId);
        return ResponseEntity.noContent().build();
    }
}
