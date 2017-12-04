package com.Redis.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * Created by Think on 2017/7/26.
 */
public class RedisJDBC {
    public static void main(String[] args) {
        //Caused by: java.net.ConnectException: Connection refused: connect

        /**
         * 注意要开始运行报错要先启动redis,运行cmd启动.找到自己安装的redis
         * eg:  C:\Program Files\AdamFile\Redis
         * 1、cmd
         * 2、cd C:\Program Files\AdamFile\Redis
         * 3、redis-server.exe redis.windows.conf
         *
         * 4、cmd
         * 5、cd C:\Program Files\AdamFile\Redis
         * 6、运行： redis-cli.exe -h 127.0.0.1 -p 6379
         *
         */

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");

        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    public void demo() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setTestWhileIdle(true);
        config.setMaxIdle(5);

       JedisPool pool = new JedisPool(config, "localhost", 6379, 10000, "");
    }

}
