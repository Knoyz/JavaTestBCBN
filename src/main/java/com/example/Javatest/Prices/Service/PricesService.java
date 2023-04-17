package com.example.Javatest.Prices.Service;

import com.example.Javatest.Prices.Model.Price;
import com.example.Javatest.Prices.PricesDTO.PriceDTO;
import com.example.Javatest.Prices.Repository.PricesRepository;
import com.example.Javatest.Prices.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesService {

    @Autowired
    PricesRepository pricesRepository;

    public Response getFinalPriceByStartDateProductIdBrandId(LocalDateTime givenDate, int productId, int brandId) {

        List<Price> prices = pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(productId, brandId, givenDate, givenDate);

        PriceDTO pFinal;
        Response response = new Response();

        if (prices != null && !prices.isEmpty()) {
            pFinal = new PriceDTO();
            pFinal.setBrandID(prices.get(0).getBrandId());
            pFinal.setPriceList(prices.get(0).getPriceList());
            pFinal.setStartDate(prices.get(0).getStartDate());
            pFinal.setEndDate(prices.get(0).getEndDate());
            pFinal.setProductId(prices.get(0).getProductId());
            pFinal.setPrice(prices.get(0).getPrice());

            response.setPriceDTO(pFinal);
            response.setHttpStatus(HttpStatus.OK);
            response.setResponse("Operacion existosa!");
        } else {
            response.setHttpStatus(HttpStatus.NO_CONTENT);
            response.setResponse("Perticion de resultado nulo o vacio, rectifique sus valores.");
        }
        return response;
    }

    public Response findByPriceList(int priceList) {

        Response response = new Response();
        List<Price> prices = pricesRepository.findByPriceList(priceList);
        PriceDTO priceDTO = new PriceDTO();

        if (prices != null && !prices.isEmpty()) {
            priceDTO.setBrandID(prices.get(0).getBrandId());
            priceDTO.setPriceList(prices.get(0).getPriceList());
            priceDTO.setStartDate(prices.get(0).getStartDate());
            priceDTO.setEndDate(prices.get(0).getEndDate());
            priceDTO.setProductId(prices.get(0).getProductId());
            priceDTO.setPrice(prices.get(0).getPrice());

            response.setPriceDTO(priceDTO);
            response.setHttpStatus(HttpStatus.OK);
            response.setResponse("Operacion existosa!");
        } else {
            response.setHttpStatus(HttpStatus.NO_CONTENT);
            response.setResponse("Perticion de resultado nulo o vacio, rectifique sus valores.");
        }
        return response;
    }
}
