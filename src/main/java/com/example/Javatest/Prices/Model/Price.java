package com.example.Javatest.Prices.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @JsonProperty("brand_id")
    @NotNull
    int brandId;

    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @NotNull
    LocalDateTime startDate;

    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @NotNull
    LocalDateTime endDate;

    @JsonProperty("price_list")
    @NotNull
    int priceList;

    @JsonProperty("product_id")
    @NotNull
    int productId;

    @JsonProperty("priority")
    @NotNull
    int priority;

    @JsonProperty("price")
    @NotNull
    double price;

    @JsonProperty("curr")
    @NotNull
    String curr;

    public Price() {
    }

    public Price(int brandId, @NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate, int priceList, int productId, int priority, double price, String curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

}
