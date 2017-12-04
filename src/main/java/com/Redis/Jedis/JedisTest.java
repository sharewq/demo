package com.Redis.Jedis;

import com.Redis.bean.User;

/**
 * Created by Think on 2017/11/1.
 */
public class JedisTest {
    private static String cache_name = "test";

    public static void main(String[] args) {
        // 存数据-String
        String str = "setA";
        JedisUtil.set(cache_name, str, "存放数据A", 10);

        String value = JedisUtil.get(cache_name, str);
        System.out.println("key=" + str + " value=" + value);

        //存数据-User
        User user = new User();  //peson类记得实现序列化接口 Serializable
        user.setPassword("存放数据对象 B");
        user.setName("B");
        user.setId("1002");
        //JedisUtil.hset(cache_name, user.getId(), user);

        User user1 = JedisUtil.get(User.class, cache_name, user.getId());
        System.out.println(user1.getName());
        System.out.println(user1.getPassword());


        JedisUtil.del(cache_name, user.getId());

        User user3 = JedisUtil.get(User.class, cache_name, user.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getPassword());

    }

}