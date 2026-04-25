package com.vaibhav.hrms.middleware.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "hrms.exchange";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue idamQueue() {
        return new Queue("idam.queue");
    }

    @Bean
    public Queue crmQueue() {
        return new Queue("crm.queue");
    }

    @Bean
    public Queue cmsQueue() {
        return new Queue("cms.queue");
    }

    @Bean
    public Binding idamBinding(Queue idamQueue, TopicExchange exchange) {
        return BindingBuilder.bind(idamQueue)
                .to(exchange)
                .with("employee.*");
    }

    @Bean
    public Binding crmBinding(Queue crmQueue, TopicExchange exchange) {
        return BindingBuilder.bind(crmQueue)
                .to(exchange)
                .with("employee.created");
    }

    @Bean
    public Binding cmsBinding(Queue cmsQueue, TopicExchange exchange) {
        return BindingBuilder.bind(cmsQueue)
                .to(exchange)
                .with("employee.*");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}