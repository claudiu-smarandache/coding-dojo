package com.assignment.spring.service;

import com.assignment.spring.api.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherRestApiServiceImpl implements WeatherRestApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public ResponseEntity<WeatherResponse> getWeather(String city) {
        String url = apiUrl.replace("{city}", city).replace("{appid}", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        return response;
    }
}
