package com.assignment.spring.mapper;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dto.ServiceResponse;
import com.assignment.spring.dto.WeatherServiceResponse;

public class WeatherMapper {

    public static WeatherServiceResponse map(WeatherResponse response) {
        WeatherServiceResponse weatherServiceResponse = new WeatherServiceResponse();
        weatherServiceResponse.setCity(response.getName());
        weatherServiceResponse.setCountry(response.getSys().getCountry());
        weatherServiceResponse.setTemperature(response.getMain().getTemp());
        return weatherServiceResponse;
    }
}
