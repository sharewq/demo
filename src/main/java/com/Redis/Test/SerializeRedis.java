package com.Redis.Test;

import com.Redis.bean.User;
import redis.clients.jedis.Jedis;

import java.io.*;

/**
 * Created by Think on 2017/11/1.
 */
public class SerializeRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        String keys = "name";
        // 删数据
        //jedis.del(keys);
        // 存数据
        jedis.set(keys, "zy");
        // 取数据
        String value = jedis.get(keys);
        System.out.println(value);

        //User
        User p = new User();  //peson类记得实现序列化接口 Serializable
        p.setPassword("密码忘记了1025");
        p.setName("王强");
        p.setId("1025");
        jedis.set(p.getId().getBytes(), serialize(p));
        byte[] byt = jedis.get("person".getBytes());
        Object obj = unserizlize(byt);
        if (obj instanceof User) {
            System.out.println(((User) obj).getName());
            System.out.println(((User) obj).getPassword());
        }
    }

    //序列化
    public static byte[] serialize(Object obj) {
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;
        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt = bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt) {
        ObjectInputStream oii = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(byt);
        try {
            oii = new ObjectInputStream(bis);
            Object obj = oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
