package com.RabbitMq.Receiver;


import com.RabbitMq.Model.User;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Think on 2017/7/25.
 */
@Component
public class ObjectReceiver {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ObjectReceiver.class);

    @RabbitListener(queues = "object")
    public void process(User user) {
        logger.info(String.format("receive object: %s", user));
    }

}
