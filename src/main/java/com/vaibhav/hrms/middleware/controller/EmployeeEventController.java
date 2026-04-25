package com.vaibhav.hrms.middleware.controller;

import com.vaibhav.hrms.middleware.dto.EmployeeEventRequest;
import com.vaibhav.hrms.middleware.service.EventPublisher;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeEventController {

    private final EventPublisher eventPublisher;

    public EmployeeEventController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/events")
    public ResponseEntity<String> handleEvent(
            @Valid @RequestBody EmployeeEventRequest request
    ) {

        eventPublisher.publishEvent(request);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Event received and published");
    }
}
