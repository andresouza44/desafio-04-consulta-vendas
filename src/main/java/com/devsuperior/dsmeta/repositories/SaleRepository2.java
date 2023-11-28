package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository2 extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj.id, obj.amount, obj.date, obj.seller.name) " +
            "FROM Sale obj " +
            "WHERE obj.date BETWEEN :minDate AND :maxDate " +
            "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<SaleMinDTO> searchByNameDate(LocalDate minDate, LocalDate maxDate,
                                      String name, Pageable pageable);


}

/*
"WHERE obj.date BETWEEN '2022-05-01' AND '2022-05-31' " +
                 "AND obj.seller.name LIKE CONCAT('%', 'Odinson', '%'")


@Query("SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj.id, obj.amount, obj.date, obj.seller.name) " +
        "FROM Sale obj " +
        "WHERE obj.date BETWEEN :minDate AND :maxDate " +
        "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
Page<SaleMinDTO> searchReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);
/*


 */




/*
SELECT sales.id, sales.date, sales.amount, seller.name
FROM tb_seller AS seller
INNER JOIN tb_sales AS sales ON sales.seller_id = seller.id
WHERE sales.date BETWEEN '2022-05-01' AND '2022-05-31'
AND seller.name LIKE '%Odinson%'
 */