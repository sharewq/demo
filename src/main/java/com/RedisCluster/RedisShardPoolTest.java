package com.RedisCluster;

import redis.clients.jedis.*;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Think on 2017/11/3.
 */
public class RedisShardPoolTest {
    static ShardedJedisPool pool;

    static {

        JedisPoolConfig config = new JedisPoolConfig();//Jedis池配置
        // config.setMaxActive(500);//最大活动的对象个数
        config.setMaxTotal(5);//最大活动的对象个数
        config.setMaxIdle(1000 * 60);//对象最大空闲时间
        config.setMaxWaitMillis(1000 * 10);//获取对象时最大等待时间
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        //String hostA = "100.98.100.242";
        String hostA = "127.0.0.1";
        //int portA = 7000;
        int portA = 6379;
        String hostB = "127.0.0.1";
        //int portB = 7001;
        int portB = 6380;
        List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>(2);
        JedisShardInfo infoA = new JedisShardInfo(hostA, portA);
        JedisShardInfo infoB = new JedisShardInfo(hostB, portB);
        jdsInfoList.add(infoA);
        jdsInfoList.add(infoB);
        pool = new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH,
                Sharded.DEFAULT_KEY_TAG_PATTERN);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String key = generateKey();
            ShardedJedis jds = null;
            try {
                jds = pool.getResource();
                System.out.println(key + ":" + "IP = " + jds.getShard(key).getClient().getHost() + "prot = " + jds.getShard(key).getClient().getPort());
                System.out.println(jds.set(key, "测试第 i= " + i + "个数据"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pool.close();
            }
        }

        for (int i = 0; i < 10; i++) {
            String key = generateKey();
            ShardedJedis jds = null;
            try {
                jds = pool.getResource();
                System.out.println(jds.get("1_" + i) + jds.getShard(key).getClient().getHost() + "prot = " + jds.getShard(key).getClient().getPort());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pool.close();
            }
        }
    }

    private static int index = 1;

    public static String

    generateKey() {
        return String.valueOf(Thread.currentThread().getId()) + "_" + (index++);
    }
}
