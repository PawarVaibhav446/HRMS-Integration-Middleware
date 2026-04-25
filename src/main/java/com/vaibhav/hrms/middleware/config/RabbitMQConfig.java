package com.vaibhav.hrms.middleware.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "hrms.exchange";

    public static final String IDAM_QUEUE = "idam.queue";
    public static final String CRM_QUEUE = "crm.queue";
    public static final String CMS_QUEUE = "cms.queue";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue idamQueue() {
        return new Queue(IDAM_QUEUE);
    }

    @Bean
    public Queue crmQueue() {
        return new Queue(CRM_QUEUE);
    }

    @Bean
    public Queue cmsQueue() {
        return new Queue(CMS_QUEUE);
    }

    @Bean
    public Binding idamBinding() {
        return BindingBuilder
                .bind(idamQueue())
                .to(exchange())
                .with("employee.*");
    }

    @Bean
    public Binding crmBinding() {
        return BindingBuilder
                .bind(crmQueue())
                .to(exchange())
                .with("employee.created");
    }

    @Bean
    public Binding cmsBinding() {
        return BindingBuilder
                .bind(cmsQueue())
                .to(exchange())
                .with("employee.deleted");
    }
}