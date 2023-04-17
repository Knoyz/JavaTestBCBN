package com.example.Javatest.Prices.PriceRestController;

import com.example.Javatest.Prices.Model.Price;
import com.example.Javatest.Prices.Repository.PricesRepository;
import com.example.Javatest.Prices.Service.PricesService;
import com.example.Javatest.Prices.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PricesRestController {

    @Autowired
    PricesRepository pricesRepository;

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

    @PostMapping("/llenarTabla")
    public ResponseEntity<List<Price>> llenarTabla() {

        Price price1 = new Price(1, LocalDateTime.of(2020, 06, 14, 0, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.50, "EUR");
        Price price2 = new Price(1, LocalDateTime.of(2020, 06, 14, 15, 00, 00), LocalDateTime.of(2020, 06, 14, 18, 30, 00), 2, 35455, 1, 25.45, "EUR");
        Price price3 = new Price(1, LocalDateTime.of(2020, 06, 15, 00, 00, 00), LocalDateTime.of(2020, 06, 15, 11, 00, 00), 3, 35455, 1, 30.50, "EUR");
        Price price4 = new Price(1, LocalDateTime.of(2020, 06, 15, 16, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 4, 35455, 1, 38.95, "EUR");

        pricesRepository.save(price1);
        pricesRepository.save(price2);
        pricesRepository.save(price3);
        pricesRepository.save(price4);

        List<Price> lp = pricesRepository.findAll();

        return new ResponseEntity<>(lp, HttpStatus.OK);

    }

}
