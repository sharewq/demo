package com.RabbitMq.Sender;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class TopicASender {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TopicASender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend("topicExchange", "topic.a", message);
        logger.info(String.format("send topic a message: %s", message));
    }

}