package com.RabbitMq.Test;


import com.RabbitMq.Model.User;
import com.RabbitMq.Sender.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 对象发送与接收
 * Created by Think on 2017/7/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

    @Autowired
    private ObjectSender objectSender;

    @Test
    public void test() {
        User user = new User();
        user.setId(1L);
        user.setName("ConanLi");
        objectSender.send(user);
    }

}