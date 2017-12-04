package com.RabbitMq.Receiver;


import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class FanoutAReceiver {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FanoutAReceiver.class);

    @RabbitListener(queues = "fanout.a")
    public void process(String message) {
        logger.info(String.format("receive fanout a message: %s", message));
    }

}
