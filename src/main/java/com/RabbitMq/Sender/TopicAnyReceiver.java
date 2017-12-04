package com.RabbitMq.Sender;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class TopicAnyReceiver {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TopicAnyReceiver.class);

    @RabbitListener(queues = "topic.any")
    public void process(String message) {
        logger.info(String.format("receive topic any message: %s", message));
    }

}