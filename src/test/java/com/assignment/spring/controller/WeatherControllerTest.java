package com.assignment.spring.controller;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.service.WeatherRestApiService;
import com.assignment.spring.service.WeatherService;
import com.assignment.spring.util.TestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherRestApiService weatherRestApiService;


    @MockBean
    private WeatherService weatherService;

    @Test
    public void whenGetWeatherByCity_thenReturnTheCity() throws Exception {
        String city = "Bucharest";

        WeatherResponse weatherResponse = TestDataBuilder
                .getValidWeatherResponse(city, "Romania", 200.0);

        ResponseEntity<WeatherResponse> weatherResponseEntity = new ResponseEntity<>(weatherResponse, HttpStatus.OK);
        Mockito.when(weatherRestApiService.getWeather(any())).thenReturn(weatherResponseEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/weather?city=" + city)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.city", is(city)));
    }

    @Test
    public void whenCityIsInvalid_thenReturnError() throws Exception {
        String city = "1Bucharest";

        mockMvc.perform(MockMvcRequestBuilders.get("/weather?city=" + city)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.responseCode", is("400")));
    }

}
