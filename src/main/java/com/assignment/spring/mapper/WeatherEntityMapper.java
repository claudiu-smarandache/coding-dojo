package com.assignment.spring.mapper;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dto.ServiceResponse;
import com.assignment.spring.model.WeatherEntity;

public class WeatherEntityMapper {

    public static WeatherEntity map(WeatherResponse response) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity(response.getName());
        weatherEntity.setCountry(response.getSys().getCountry());
        weatherEntity.setTemperature(response.getMain().getTemp());
        return weatherEntity;
    }
}
