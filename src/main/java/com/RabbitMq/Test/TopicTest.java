package com.RabbitMq.Test;

import com.RabbitMq.Sender.TopicASender;
import com.RabbitMq.Sender.TopicAnySender;
import com.RabbitMq.Sender.TopicBSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 最灵活的一种方式，可以根据routing_Key自由的绑定不同的队列。
 * Created by Think on 2017/7/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicASender topicASender;
    @Autowired
    private TopicBSender topicBSender;
    @Autowired
    private TopicAnySender topicAnySender;

    @Test
    public void topicA() {
        topicASender.send("tag");
    }

    @Test
    public void topicB() {
        topicBSender.send("tag");
    }

    @Test
    public void topicAny() {
        topicAnySender.send("tag");
    }

}