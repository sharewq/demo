package com.Redis.JedisCluster;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * 分布式-分片式
 * Created by Think on 2017/11/6.
 */
public class ShardedJedisTest {

    static ShardedJedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();//Jedis池配置
        //config.setMaxActive(500);                 //最大活动的对象个数 - 以前版本的
        config.setMaxTotal(50);                     //最大连接数
        config.setMaxIdle(8);                       //最大空闲连接数, 默认8个
        config.setMinIdle(1);                       //最小空闲连接数, 默认0
        //config.setMaxWait(1000 * 10);             //获取对象时最大等待时间 - 以前版本的
        config.setMaxWaitMillis(1000 * 10);         //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1

        config.setTestOnBorrow(true);               //在获取连接的时候检查有效性, 默认false
        config.setTestOnReturn(true);               //在空闲时检查有效性, 默认false
        config.setTestWhileIdle(true);              //在归还给pool时，是否提前进行validate操作
        String hostA = "192.168.2.162";
        int portA = 30001;
        //String hostB = "192.168.2.162";
        //int portB = 6379;
        List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>(1);
        JedisShardInfo infoA = new JedisShardInfo(hostA, portA);
        infoA.setPassword("");
        //JedisShardInfo infoB = new JedisShardInfo(hostB, portB);
        //infoB.setPassword("");
        jdsInfoList.add(infoA);
        //jdsInfoList.add(infoB);

        pool = new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH,
                Sharded.DEFAULT_KEY_TAG_PATTERN);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String key = generateKey();
            //key += "{aaa}";
            ShardedJedis jds = null;
            try {
                jds = pool.getResource();
                System.out.println(key + ":" + jds.getShard(key).getClient().getHost());
                System.out.println(jds.set(key, "1111111111111111111111111111111"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pool.returnResource(jds);
            }
        }
    }

    private static int index = 1;

    public static String

    generateKey() {
        return String.valueOf(Thread.currentThread().getId()) + "_" + (index++);
    }
}
