
package com.assignment.spring.dto;

import com.assignment.spring.api.*;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceResponse {
    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("responseMessage")
    private String responseMessage;

    public ServiceResponse() {
    }

    public ServiceResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    @JsonProperty("responseCode")
    public String getResponseCode() {
        return responseCode;
    }

    @JsonProperty("responseCode")
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @JsonProperty("responseMessage")
    public String getResponseMessage() {
        return responseMessage;
    }

    @JsonProperty("responseMessage")
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
