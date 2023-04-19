package com.example.Javatest.Prices.PriceRestController;

import com.example.Javatest.Prices.Repository.PricesRepository;
import com.example.Javatest.Prices.Service.PricesService;
import com.example.Javatest.Prices.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/prices")
public class PricesRestController {

    @Autowired
    PricesService pricesService;

    @GetMapping("/consultarPrecioFinal")
    public ResponseEntity<Response> precioFinalByStartDateProductIdBrandId(
            @RequestParam(value = "given_date") String givenDate,
            @RequestParam(value = "product_id") int productId,
            @RequestParam(value = "brand_id") int brandId) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

        LocalDateTime dateTime = LocalDateTime.parse(givenDate, dtf);

        Response response = pricesService.getFinalPriceByStartDateProductIdBrandId(dateTime, productId, brandId);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/obtenerPorListaDePrecios/{price_list}")
    public ResponseEntity<Response> allOfOnePriceList(@PathVariable int price_list) {

        Response response = pricesService.findByPriceList(price_list);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
