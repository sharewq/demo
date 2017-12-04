package com.RabbitMq.Sender;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class MessageSender1 {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MessageSender1.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend("many", message);
        logger.info(String.format("send(1) message: %s", message));
    }

}