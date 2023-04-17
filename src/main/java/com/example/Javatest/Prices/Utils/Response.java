package com.example.Javatest.Prices.Utils;

import com.example.Javatest.Prices.PricesDTO.PriceDTO;
import org.springframework.http.HttpStatus;

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

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public PriceDTO getPriceDTO() {
        return priceDTO;
    }

    public void setPriceDTO(PriceDTO priceDTO) {
        this.priceDTO = priceDTO;
    }
}
