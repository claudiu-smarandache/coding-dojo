package com.assignment.spring.service;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.util.TestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class WeatherRestApiServiceTest {

    @InjectMocks
    private WeatherRestApiServiceImpl weatherRestApiService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void whenGetWeatherByCity_thenReturnTheCity(){
        String city = "Bucharest";

        WeatherResponse weatherResponse = TestDataBuilder
                .getValidWeatherResponse(city, "Romania", 200.0);

        ResponseEntity<WeatherResponse> weatherResponseEntity = new ResponseEntity<>(weatherResponse, HttpStatus.OK);

        Mockito.when(restTemplate.getForEntity("", WeatherResponse.class)).thenReturn(weatherResponseEntity);

        ReflectionTestUtils.setField(weatherRestApiService, "apiUrl", "");
        ReflectionTestUtils.setField(weatherRestApiService, "apiKey", "");

        ResponseEntity<WeatherResponse> result = weatherRestApiService.getWeather(city);
        Assertions.assertEquals(city, result.getBody().getName());
    }
}
