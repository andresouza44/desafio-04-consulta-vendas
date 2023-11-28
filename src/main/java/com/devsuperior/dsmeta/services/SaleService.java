package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<SaleMinDTO> findAll(String dataInicial, String dataFinal,
                                    String name, Pageable pageable) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate maxDate;
        LocalDate minDate;

        if (dataFinal.isEmpty()) {
            maxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        } else {
            maxDate = LocalDate.parse(dataFinal, formatter);
        }
        if (dataInicial.isEmpty()) {
            minDate = maxDate.minusYears(1);
        } else {
            minDate = LocalDate.parse(dataInicial, formatter);
        }
        return repository.searchByNameDate(minDate, maxDate, name, pageable);



    }
}
