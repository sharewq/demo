package com.RabbitMq.Test;

import com.RabbitMq.Sender.MessageSender1;
import com.RabbitMq.Sender.MessageSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * M个发送者，N个接收者，消息会均匀的发送到N个接收者中。
 * Created by Think on 2017/7/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {

    @Autowired
    private MessageSender1 messageSender1;
    @Autowired
    private MessageSender2 messageSender2;

    @Test
    public void manyToMany() {
        for (int i = 0; i < 10; i++) {
            messageSender1.send(String.format("hi(%d)", i + 1));
            messageSender2.send(String.format("hi(%d)", i + 1));
        }
    }

}