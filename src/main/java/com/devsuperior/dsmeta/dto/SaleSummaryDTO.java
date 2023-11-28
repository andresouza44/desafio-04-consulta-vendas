package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleSummaryDTO {

    String sellerName;
    Double amount;

    public SaleSummaryDTO(){

    }

    public SaleSummaryDTO(String sellerName, Double amount) {
        this.sellerName = sellerName;
        this.amount = amount;
    }

    public SaleSummaryDTO(Sale sale){
        sellerName = sale.getSeller().getName();
        amount = sale.getAmount();
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getAmount() {
        return amount;
    }
}
