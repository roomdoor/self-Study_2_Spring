package com.example.chapter0802.controller;


import com.example.chapter0802.component.Calculator;
import com.example.chapter0802.component.DollarCalculator;
import com.example.chapter0802.component.MarketApi;
import com.example.chapter0802.dto.Req;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;

@WebMvcTest(CalculatorApiController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class,})
public class CalculatorApiControllerTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sunTest() throws Exception {
        //http://localhost:8080/api/sum

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/sum")
                .queryParam("x", "10")
                .queryParam("y", "10")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void minusPostTest() throws Exception {
        Req req = new Req(10, 10);

        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/post/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.result").value("0")
                ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
                )
                .andDo(MockMvcResultHandlers.print());
    }
}
