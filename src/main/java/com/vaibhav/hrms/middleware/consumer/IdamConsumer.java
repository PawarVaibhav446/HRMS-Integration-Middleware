package com.vaibhav.hrms.middleware.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.vaibhav.hrms.middleware.dto.EmployeeEventRequest;

@Component
public class IdamConsumer {

    @RabbitListener(queues = "idam.queue")
    public void consume(EmployeeEventRequest request) {

        System.out.println("IDAM received event: " + request.getEventType());
        System.out.println("Data: " + request.getData());

        // Simulate processing
        System.out.println("Processing in IDAM...");
    }
}