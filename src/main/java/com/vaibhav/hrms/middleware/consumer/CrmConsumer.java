package com.vaibhav.hrms.middleware.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.vaibhav.hrms.middleware.dto.EmployeeEventRequest;

@Component
public class CrmConsumer {

    @RabbitListener(queues = "crm.queue")
    public void consume(EmployeeEventRequest request) {

        System.out.println("CRM received event: " + request.getEventType());
        System.out.println("Processing in CRM...");
    }
}