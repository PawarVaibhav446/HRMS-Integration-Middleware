package com.vaibhav.hrms.middleware.service;

import com.vaibhav.hrms.middleware.dto.EmployeeEventRequest;
import com.vaibhav.hrms.middleware.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishEvent(EmployeeEventRequest request) {
        String routingKey = request.getEventType().getRoutingKey();

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                routingKey,
                request
        );

        System.out.println("Published event with routing key: " + routingKey);
    }
}