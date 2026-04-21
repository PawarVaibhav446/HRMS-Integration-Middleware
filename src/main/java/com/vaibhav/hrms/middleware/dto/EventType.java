package com.vaibhav.hrms.middleware.dto;

public enum EventType {
    EMPLOYEE_CREATED("employee.created"),
    EMPLOYEE_UPDATED("employee.updated"),
    EMPLOYEE_DELETED("employee.deleted");

    private final String routingKey;

    EventType(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getRoutingKey() {
        return routingKey;
    }
}
