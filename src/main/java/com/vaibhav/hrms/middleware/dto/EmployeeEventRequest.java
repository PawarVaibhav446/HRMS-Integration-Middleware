package com.vaibhav.hrms.middleware.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Data
public class EmployeeEventRequest {

    @NotNull(message = "eventType is required")
    private EventType eventType;

    @NotNull(message = "data cannot be null")
    private Map<String, Object> data;

}
