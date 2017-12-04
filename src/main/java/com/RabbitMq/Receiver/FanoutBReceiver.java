package com.RabbitMq.Receiver;


import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class FanoutBReceiver {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FanoutBReceiver.class);

    @RabbitListener(queues = "fanout.b")
    public void process(String message) {
        logger.info(String.format("receive fanout b message: %s", message));
    }

}