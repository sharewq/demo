package com.RabbitMq.Rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Think on 2017/7/25.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue manyQueue() {
        return new Queue("many");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }

}