
package com.assignment.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherServiceResponse extends ServiceResponse {

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("temperature")
    private Double temperature;


    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("temperature")
    public Double getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
