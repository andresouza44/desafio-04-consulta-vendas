package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.services.utils.DataUtil;
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
    public Page<SaleMinDTO> findAll(String minDate, String maxDate,
                                    String name, Pageable pageable) {

        LocalDate maxDateResult = DataUtil.getMaxDate(maxDate);
        LocalDate minDateResult = DataUtil.getMinDate(minDate,maxDateResult);

        return repository.searchByNameDate(minDateResult, maxDateResult, name, pageable);

    }

    public Page<SaleMinDTO> sumary(String minDate, String maxDate, Pageable pageable) {
     return null;
    }

}
