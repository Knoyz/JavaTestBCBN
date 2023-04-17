package com.example.Javatest.Prices.Service;

import com.example.Javatest.Prices.Model.Price;
import com.example.Javatest.Prices.PricesDTO.PriceDTO;
import com.example.Javatest.Prices.Repository.PricesRepository;
import com.example.Javatest.Prices.Utils.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PriceServiceTest {

    @Autowired
    PricesRepository pricesRepository;

    @Autowired
    PricesService pricesService;

    Price price1 = new Price(1, LocalDateTime.of(2020, 06, 14, 00, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.50, "EUR");
    Price price2 = new Price(1, LocalDateTime.of(2020, 06, 14, 15, 00, 00), LocalDateTime.of(2020, 06, 14, 18, 30, 00), 2, 35455, 1, 25.45, "EUR");
    Price price3 = new Price(1, LocalDateTime.of(2020, 06, 15, 00, 00, 00), LocalDateTime.of(2020, 06, 15, 11, 00, 00), 3, 35455, 1, 30.50, "EUR");
    Price price4 = new Price(1, LocalDateTime.of(2020, 06, 15, 16, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 4, 35455, 1, 38.95, "EUR");

    public void initializeData() {
        pricesRepository.save(price1);
        pricesRepository.save(price2);
        pricesRepository.save(price3);
        pricesRepository.save(price4);
    }

    @Test
    void getFinalPriceByDateProductIdBrandId_Test1(){

        /*
        * Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        */
        initializeData();

        PriceDTO priceDTOExpected = new PriceDTO();
        priceDTOExpected.setBrandID(1);
        priceDTOExpected.setProductId(35455);
        priceDTOExpected.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
        priceDTOExpected.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDTOExpected.setPriceList(1);
        priceDTOExpected.setPrice(35.50);

        Response response = pricesService.getFinalPriceByStartDateProductIdBrandId(LocalDateTime.of(2020, 06, 14, 10, 00, 00),
                35455, 1);
        PriceDTO priceDTOResult = response.getPriceDTO();

        assertEquals(priceDTOExpected.getBrandID(), priceDTOResult.getBrandID());
        assertEquals(priceDTOExpected.getStartDate(), priceDTOResult.getStartDate());
        assertEquals(priceDTOExpected.getProductId(), priceDTOResult.getProductId());
        assertEquals(priceDTOExpected.getEndDate(), priceDTOResult.getEndDate());
        assertEquals(priceDTOExpected.getPriceList(), priceDTOResult.getPriceList());
        assertEquals(priceDTOExpected.getPrice(), priceDTOResult.getPrice());
    }

    @Test
    void getFinalPriceByDateProductIdBrandId_Test2(){
        /*
         * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
         */
        initializeData();

        PriceDTO priceDTOExpected = new PriceDTO();
        priceDTOExpected.setBrandID(1);
        priceDTOExpected.setProductId(35455);
        priceDTOExpected.setStartDate(LocalDateTime.of(2020, 06, 14, 15, 00, 00));
        priceDTOExpected.setEndDate(LocalDateTime.of(2020, 06, 14, 18, 30, 00));
        priceDTOExpected.setPriceList(2);
        priceDTOExpected.setPrice(25.45);

        Response response = pricesService.getFinalPriceByStartDateProductIdBrandId(LocalDateTime.of(2020, 06, 14, 16, 00, 00),
                35455, 1);
        PriceDTO priceDTOResult = response.getPriceDTO();

        assertEquals(priceDTOExpected.getBrandID(), priceDTOResult.getBrandID());
        assertEquals(priceDTOExpected.getStartDate(), priceDTOResult.getStartDate());
        assertEquals(priceDTOExpected.getProductId(), priceDTOResult.getProductId());
        assertEquals(priceDTOExpected.getEndDate(), priceDTOResult.getEndDate());
        assertEquals(priceDTOExpected.getPriceList(), priceDTOResult.getPriceList());
        assertEquals(priceDTOExpected.getPrice(), priceDTOResult.getPrice());
    }

    @Test
    void getFinalPriceByDateProductIdBrandId_Test3(){
        /*
        Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
         */
        initializeData();

        PriceDTO priceDTOExpected = new PriceDTO();
        priceDTOExpected.setBrandID(1);
        priceDTOExpected.setProductId(35455);
        priceDTOExpected.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
        priceDTOExpected.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDTOExpected.setPriceList(1);
        priceDTOExpected.setPrice(35.50);

        Response response = pricesService.getFinalPriceByStartDateProductIdBrandId(LocalDateTime.of(2020, 06, 14, 21, 00, 00),
                35455, 1);
        PriceDTO priceDTOResult = response.getPriceDTO();

        assertEquals(priceDTOExpected.getBrandID(), priceDTOResult.getBrandID());
        assertEquals(priceDTOExpected.getStartDate(), priceDTOResult.getStartDate());
        assertEquals(priceDTOExpected.getProductId(), priceDTOResult.getProductId());
        assertEquals(priceDTOExpected.getEndDate(), priceDTOResult.getEndDate());
        assertEquals(priceDTOExpected.getPriceList(), priceDTOResult.getPriceList());
        assertEquals(priceDTOExpected.getPrice(), priceDTOResult.getPrice());
    }

    @Test
    void getFinalPriceByDateProductIdBrandId_Test4(){
        /*
        Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
         */
        initializeData();

        PriceDTO priceDTOExpected = new PriceDTO();
        priceDTOExpected.setBrandID(1);
        priceDTOExpected.setProductId(35455);
        priceDTOExpected.setStartDate(LocalDateTime.of(2020, 06, 15, 00, 00, 00));
        priceDTOExpected.setEndDate(LocalDateTime.of(2020, 06, 15, 11, 00, 00));
        priceDTOExpected.setPriceList(3);
        priceDTOExpected.setPrice(30.50);

        Response response = pricesService.getFinalPriceByStartDateProductIdBrandId(LocalDateTime.of(2020, 06, 15, 10, 00, 00),
                35455, 1);
        PriceDTO priceDTOResult = response.getPriceDTO();

        assertEquals(priceDTOExpected.getBrandID(), priceDTOResult.getBrandID());
        assertEquals(priceDTOExpected.getStartDate(), priceDTOResult.getStartDate());
        assertEquals(priceDTOExpected.getProductId(), priceDTOResult.getProductId());
        assertEquals(priceDTOExpected.getEndDate(), priceDTOResult.getEndDate());
        assertEquals(priceDTOExpected.getPriceList(), priceDTOResult.getPriceList());
        assertEquals(priceDTOExpected.getPrice(), priceDTOResult.getPrice());
    }

    @Test
    void getFinalPriceByDateProductIdBrandId_Test5(){
        /*
        Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
         */
        initializeData();

        PriceDTO priceDTOExpected = new PriceDTO();
        priceDTOExpected.setBrandID(1);
        priceDTOExpected.setProductId(35455);
        priceDTOExpected.setStartDate(LocalDateTime.of(2020, 06, 15, 16, 00, 00));
        priceDTOExpected.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDTOExpected.setPriceList(4);
        priceDTOExpected.setPrice(38.95);

        Response response = pricesService.getFinalPriceByStartDateProductIdBrandId(LocalDateTime.of(2020, 06, 16, 21, 00, 00),
                35455, 1);
        PriceDTO priceDTOResult = response.getPriceDTO();

        assertEquals(priceDTOExpected.getBrandID(), priceDTOResult.getBrandID());
        assertEquals(priceDTOExpected.getStartDate(), priceDTOResult.getStartDate());
        assertEquals(priceDTOExpected.getProductId(), priceDTOResult.getProductId());
        assertEquals(priceDTOExpected.getEndDate(), priceDTOResult.getEndDate());
        assertEquals(priceDTOExpected.getPriceList(), priceDTOResult.getPriceList());
        assertEquals(priceDTOExpected.getPrice(), priceDTOResult.getPrice());
    }
}