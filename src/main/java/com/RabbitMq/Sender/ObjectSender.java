package com.RabbitMq.Sender;

import com.RabbitMq.Model.User;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class ObjectSender {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ObjectSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        rabbitTemplate.convertAndSend("object", user);
        logger.info(String.format("send object: %s", user));
    }

}