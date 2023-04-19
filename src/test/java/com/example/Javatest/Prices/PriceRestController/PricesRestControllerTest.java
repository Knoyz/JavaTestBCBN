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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
class PricesRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    PricesService pricesService;

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
}