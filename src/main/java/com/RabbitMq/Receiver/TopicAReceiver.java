package com.RabbitMq.Receiver;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class TopicAReceiver {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TopicAReceiver.class);

    @RabbitListener(queues = "topic.a")
    public void process(String message) {
        logger.info(String.format("receive topic a message: %s", message));
    }

}
