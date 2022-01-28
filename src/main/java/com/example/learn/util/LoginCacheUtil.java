package com.example.learn.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiuce
 * @version 1.0
 * @date 2021/12/22 6:48 下午
 */
@Slf4j
public class LoginCacheUtil {
    //默认大小
    private static final int DEFAULT_CAPACITY = 1024;

    // 最大缓存大小
    private static final int MAX_CAPACITY = 10000;

    //默认缓存过期时间
    private static final long DEFAULT_TIMEOUT = 60 * 1000;

    //1000毫秒
    private static final long SECOND_TIME = 1000;

    //存储缓存的Map
    private static final ConcurrentHashMap<String, Object> map;

    private static final Timer timer;

    static {
        map = new ConcurrentHashMap<>(DEFAULT_CAPACITY);
        timer = new Timer();
    }

    //私有化构造方法
    private LoginCacheUtil() {

    }

    static class ClearTask extends TimerTask {
        private String key;

        public ClearTask(String key) {
            this.key = key;
        }

        @Override
        public void run() {
            log.info("删除缓存：{}", key);
            LoginCacheUtil.remove(key);
        }

    }

    //==================缓存的增删改查

    public static boolean put(String key, Object object) {
        if (checkCapacity()) {
            map.put(key, object);
            //默认缓存时间
            timer.schedule(new ClearTask(key), DEFAULT_TIMEOUT);
            return true;
        }
        return false;
    }

    public static boolean put(String key, Object object, int time_out) {
        if (checkCapacity()) {
            map.put(key, object);
            //默认缓存时间
            timer.schedule(new ClearTask(key), time_out * SECOND_TIME);
        }
        return false;
    }


    public static boolean checkCapacity() {
        return map.size() < MAX_CAPACITY;
    }

    public static boolean put(Map<String, Object> m, int time_out) {
        if (map.size() + m.size() <= MAX_CAPACITY) {
            map.putAll(map);
            for (String key : m.keySet()) {
                timer.schedule(new ClearTask(key), time_out * SECOND_TIME);
            }
            return true;
        }
        return false;
    }

    public static void remove(String key) {
        map.remove(key);
    }

    public void clearAll() {
        if (map.size() > 0) {
            map.clear();
        }
        timer.cancel();
    }

    public static Object get(String key) {
        return map.get(key);
    }

    public static boolean isContain(String key) {
        return map.contains(key);
    }

    public static void main(String[] args) throws InterruptedException {

        LoginCacheUtil.put("xiuce", new Object(), 2);

        Thread.sleep(2000);

        LoginCacheUtil.put("wuqifan", new Object(), 3);
    }
}
