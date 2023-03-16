package com.assignment.spring.util;

import com.assignment.spring.api.Main;
import com.assignment.spring.api.Sys;
import com.assignment.spring.api.WeatherResponse;

public class TestDataBuilder {

    public static WeatherResponse getValidWeatherResponse(String city, String country, Double temperature) {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setName(city);
        Sys sys = new Sys();
        sys.setCountry(country);
        weatherResponse.setSys(sys);
        Main main = new Main();
        main.setTemp(temperature);
        weatherResponse.setMain(main);

        return weatherResponse;
    }
}
