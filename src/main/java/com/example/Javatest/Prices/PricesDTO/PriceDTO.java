package com.example.Javatest.Prices.PricesDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceDTO {
    private int productId;
    private int brandID;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    double price;
}
