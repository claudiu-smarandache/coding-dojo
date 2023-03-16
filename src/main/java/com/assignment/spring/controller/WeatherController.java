package com.assignment.spring.controller;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dto.ServiceResponse;
import com.assignment.spring.service.WeatherRestApiService;
import com.assignment.spring.service.WeatherService;
import com.assignment.spring.util.ControllerUtils;
import com.assignment.spring.validator.WeatherInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WeatherController {

    @Autowired
    private WeatherRestApiService weatherRestApiService;

    @Autowired
    private WeatherService weatherService;



    @RequestMapping("/weather")
    public ResponseEntity<ServiceResponse> getWeather(HttpServletRequest request) {
        ServiceResponse serviceResponse = new ServiceResponse();
        String city = request.getParameter("city");

        if(!WeatherInputValidator.cityIsValid(city)){
            return new ResponseEntity<>(new ServiceResponse("400", "Input parameter 'city' is invalid"), HttpStatus.BAD_REQUEST);
        }
        else{
            try {
                ResponseEntity<WeatherResponse> weatherApiResponse = weatherRestApiService.getWeather(city);
                weatherService.saveWeather(weatherApiResponse);
                return new ResponseEntity<>(ControllerUtils.buildSuccessResponse(weatherApiResponse), HttpStatus.OK);
            }
            catch (HttpStatusCodeException exception){
                return new ResponseEntity<>(new ServiceResponse(String.valueOf(exception.getRawStatusCode()), exception.getStatusText()), exception.getStatusCode());
            }
            catch (Exception exception){
                return new ResponseEntity<>(new ServiceResponse("500", exception.getMessage().substring(0, 100)), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
