package com.vaibhav.hrms.middleware.consumer;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import com.vaibhav.hrms.middleware.dto.EmployeeEventRequest;

@Component
public class IdamConsumer {

    @RabbitListener(queues = "idam.queue")
    public void consume(EmployeeEventRequest request,
                        org.springframework.amqp.core.Message message,
                        com.rabbitmq.client.Channel channel) throws Exception {

        int retryCount = 0;

        if (message.getMessageProperties().getHeaders().get("x-retry-count") != null) {
            retryCount = (int) message.getMessageProperties().getHeaders().get("x-retry-count");
        }

        System.out.println("Retry count: " + retryCount);

        if (retryCount >= 3) {
            System.out.println("Sending to DLQ");

            channel.basicPublish(
                    "",
                    "idam.dlq",
                    null,
                    message.getBody()
            );

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            return;
        }

        // ✅ Convert headers properly
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .headers(message.getMessageProperties().getHeaders())
                .build();

        // increment retry count
        message.getMessageProperties().getHeaders().put("x-retry-count", retryCount + 1);

        channel.basicPublish(
                "",
                "idam.retry.queue",
                props,
                message.getBody()
        );

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}