package com.assignment.spring.service;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.mapper.WeatherEntityMapper;
import com.assignment.spring.model.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public void saveWeather(ResponseEntity<WeatherResponse> weatherResponse) {
        WeatherEntity entity = WeatherEntityMapper.map(weatherResponse.getBody());
        weatherRepository.save(entity);
    }
}
