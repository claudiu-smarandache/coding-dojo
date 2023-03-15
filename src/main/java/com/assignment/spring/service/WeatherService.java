package com.assignment.spring.service;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dto.ServiceResponse;
import org.springframework.http.ResponseEntity;

public interface WeatherService {
    void saveWeather(ResponseEntity<WeatherResponse> weatherResponse);
}
