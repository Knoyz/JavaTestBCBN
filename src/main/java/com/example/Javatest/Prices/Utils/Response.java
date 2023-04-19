package com.example.Javatest.Prices.Utils;

import com.example.Javatest.Prices.PricesDTO.PriceDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    HttpStatus httpStatus;
    String response;
    PriceDTO priceDTO;

    public Response() {
    }

    public Response(HttpStatus httpStatus, String response, PriceDTO priceDTO) {
        this.httpStatus = httpStatus;
        this.response = response;
        this.priceDTO = priceDTO;
    }
}
