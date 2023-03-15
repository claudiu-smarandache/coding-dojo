package com.assignment.spring.util;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dto.WeatherServiceResponse;
import com.assignment.spring.mapper.WeatherMapper;
import org.springframework.http.ResponseEntity;

public class ControllerUtils {
    public static WeatherServiceResponse buildSuccessResponse(ResponseEntity<WeatherResponse> weatherApiResponse){
        WeatherServiceResponse weatherServiceResponse = WeatherMapper.map(weatherApiResponse.getBody());
        weatherServiceResponse.setResponseMessage("Success");
        weatherServiceResponse.setResponseCode("200");
        return  weatherServiceResponse;
    }
}
