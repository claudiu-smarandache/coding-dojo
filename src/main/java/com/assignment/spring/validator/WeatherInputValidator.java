package com.assignment.spring.validator;

public class WeatherInputValidator {
    public static boolean cityIsValid(String city){
        return city.matches("^[a-zA-Z]+(?:(?:\\s+|-)[a-zA-Z]+)*$");
    }
}