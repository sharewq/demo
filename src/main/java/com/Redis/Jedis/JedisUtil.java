package com.Redis.Jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Think on 2017/11/1.
 */
public class JedisUtil {
    private static final Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    public static Jedis jedis;
    /*  redis 缓存前缀 */
    private static final String KEY_SYSTEM = "Demo";
    /*  用于隔开缓存前缀与缓存键值 */
    private static final String KEY_SPLIT = ":";

    /* jedis 初始化 */
    static {
        jedis = jedis != null ? jedis : new Jedis("localhost", 6379);
    }

    /**
     * 清空缓存
     *
     * @param cacheName
     */
    public static void clear(String cacheName) {
        try {
            jedis.del((KEY_SYSTEM + KEY_SPLIT + cacheName).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 设置缓存
     *
     * @param cacheName
     * @param key
     * @param object
     */
    public static String hset(String cacheName, String key, Object object) {
        String cacheKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        return jedis.set(cacheKey.getBytes(), JedisSerialize.serialize(object));
    }

    /**
     * 设置缓存
     *
     * @param cacheName
     * @param key
     * @param object
     */
    public static String hset(String cacheName, String key, Object object, int second) {
        String cacheKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        return jedis.setex(cacheKey.getBytes(), second, JedisSerialize.serialize(object));
    }

    /**
     * 设置缓存
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public static String set(String cacheName, String key, String value) {
        String cacheKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        return jedis.set(cacheKey, value);
    }

    /**
     * 设置缓存
     *
     * @param cacheName
     * @param key
     * @param value
     * @param second
     */
    public static String set(String cacheName, String key, String value, int second) {
        String cacheKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        return jedis.setex(cacheKey, second, value);
    }


    /**
     * 获取单条数据(对象)
     *
     * @param clazz
     * @param cacheName
     */
    public static <T> T get(Class<T> clazz, String cacheName, String key) {
        String baseKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        byte[] byt = jedis.get(baseKey.getBytes());
        return byt == null ? null : (T) JedisSerialize.deserialize(byt);
    }

    /**
     * 获取单条数据（单个）
     *
     * @param cacheName
     * @param key
     * @return
     */
    public static String get(String cacheName, String key) {
        String baseKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        return jedis.get(baseKey);
    }

    /**
     * 删除指定的缓存数据
     *
     * @param cacheName
     * @param key
     */
    public static void hdel(String cacheName, String key) {
        String baseKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        jedis.hdel(baseKey.getBytes());
    }

    /**
     * @param cacheName
     * @param key
     */
    public static void del(String cacheName, String key) {
        String baseKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        jedis.del(baseKey.getBytes());
    }

    /**
     * 更新指定的缓存数据
     *
     * @param cacheName
     * @param key
     * @param object
     */
    public static void update(String cacheName, String key, Object object) {
        String cacheKey = KEY_SYSTEM + KEY_SPLIT + cacheName + KEY_SPLIT + key;
        jedis.set(cacheKey.getBytes(), JedisSerialize.serialize(object));
    }

    public static <T> ArrayList<T> getList(Class<T> clazz, String cacheName) {
        String cacheKey = KEY_SYSTEM + KEY_SPLIT + cacheName;
        Collection<byte[]> connction = jedis.hvals(cacheKey.getBytes());
        ArrayList<T> objList = new ArrayList<T>();
        if (connction.iterator() != null) {
            for (byte[] b : connction) {
                objList.add((T) JedisSerialize.deserialize(b));
            }
        }
        return objList;
    }

}
