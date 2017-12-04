package com.RabbitMq.Receiver;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
@RabbitListener(queues = "many")
public class MessageReceiver2 {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MessageReceiver2.class);

    @RabbitHandler
    public void process(String message) {
        logger.info(String.format("receive(2) message: %s", message));
    }

}
