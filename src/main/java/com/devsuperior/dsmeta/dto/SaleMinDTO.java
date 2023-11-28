package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleMinDTO {

	private Long id;
	private LocalDate date;
	private Double amount;
	private String sellerName;


	public SaleMinDTO(Long id, LocalDate date, Double amount , String sellerName) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.sellerName = sellerName;
	}

	public SaleMinDTO(String sellerName, Double amount) {
		this.sellerName = sellerName;
		this.amount = amount;
	}

	public SaleMinDTO(Long id, Double amount, LocalDate date) {
		this.id = id;
		this.amount = amount;
		this.date = date;
	}

	public SaleMinDTO(Sale entity) {
		id = entity.getId();
		date = entity.getDate();
		amount = entity.getAmount();
		sellerName = entity.getSeller().getName();

	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getSellerName() {
		return sellerName;
	};
}