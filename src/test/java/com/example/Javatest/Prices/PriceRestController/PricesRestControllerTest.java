package com.example.Javatest.Prices.PriceRestController;

import com.example.Javatest.Prices.Model.Price;
import com.example.Javatest.Prices.Repository.PricesRepository;
import com.example.Javatest.Prices.Service.PricesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
class PricesRestControllerTest {

    private final static String BASE_URL = "/prices";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    PricesService pricesService;

    @Autowired
    PricesRepository pricesRepository;

    Price price1 = new Price(1, LocalDateTime.of(2020, 06, 14, 00, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.50, "EUR");
    Price price2 = new Price(1, LocalDateTime.of(2020, 06, 14, 15, 00, 00), LocalDateTime.of(2020, 06, 14, 18, 30, 00), 2, 35455, 1, 25.45, "EUR");
    Price price3 = new Price(1, LocalDateTime.of(2020, 06, 15, 00, 00, 00), LocalDateTime.of(2020, 06, 15, 11, 00, 00), 3, 35455, 1, 30.50, "EUR");
    Price price4 = new Price(1, LocalDateTime.of(2020, 06, 15, 16, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 4, 35455, 1, 38.95, "EUR");

    public void inizializeData() {
        pricesRepository.save(price1);
        pricesRepository.save(price2);
        pricesRepository.save(price3);
        pricesRepository.save(price4);
    }

    @BeforeEach
    void setUp() {
        inizializeData();
    }

    @Test
    void precioFinalByStartDateProductIdBrandId() throws Exception {
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/prices/consultarPrecioFinal?given_date=2020-08-25-10.00.00&product_id=35455&brand_id=1"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void allOfOnePriceListOf_4() throws Exception {
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/prices/obtenerPorListaDePrecios/4"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void llenarTabla() throws Exception {
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/prices/llenarTabla"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}