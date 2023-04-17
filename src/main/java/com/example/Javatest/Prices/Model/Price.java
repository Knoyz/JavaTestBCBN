package com.example.Javatest.Prices.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public @NotNull LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public @NotNull LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
