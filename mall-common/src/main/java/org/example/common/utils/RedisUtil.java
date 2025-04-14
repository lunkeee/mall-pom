package org.example.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类，封装常用Redis操作
 */
@Component
public class RedisUtil {
    private final RedisTemplate<String, Object> redisTemplate;

    @Value("${redis.session.prefix}")
    private String sessionTokenPrefix;

    @Value("${redis.session.expiration}") // 默认30分钟
    private long sessionTokenExpiration;

    @Autowired
    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    // ---------------------- Session Management ----------------------

    /**
     * 生成并存储会话token
     * @param username 用户名
     * @return 生成的token
     */
    public String generateSessionToken(String username) {
        String sessionToken = UUID.randomUUID().toString();
        String key = sessionTokenPrefix + username;
        redisTemplate.opsForValue().set(key, sessionToken, sessionTokenExpiration, TimeUnit.SECONDS);
        return sessionToken;
    }

    /**
     * 验证会话token
     * @param username 用户名
     * @param sessionToken 待验证的token
     * @return 是否有效
     */
    public boolean validateSessionToken(String username, String sessionToken) {
        if (username == null || sessionToken == null) {
            return false;
        }
        String key = sessionTokenPrefix + username;
        String storedSessionToken = (String) redisTemplate.opsForValue().get(key);
        return sessionToken.equals(storedSessionToken);
    }

    /**
     * 删除会话token
     * @param username 用户名
     */
    public void deleteSessionToken(String username) {
        if (username != null) {
            String key = sessionTokenPrefix + username;
            redisTemplate.delete(key);
        }
    }

    /**
     * 刷新会话token过期时间
     * @param username 用户名
     * @return 是否刷新成功
     */
    public boolean refreshSessionToken(String username) {
        if (username == null) {
            return false;
        }
        String key = sessionTokenPrefix + username;
        return Boolean.TRUE.equals(redisTemplate.expire(key, sessionTokenExpiration, TimeUnit.SECONDS));
    }

    // ---------------------- Key Operations ----------------------

    /**
     * 设置key过期时间
     * @param key 键
     * @param time 时间(秒)
     * @return 是否设置成功
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                return Boolean.TRUE.equals(redisTemplate.expire(key, time, TimeUnit.SECONDS));
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取key过期时间
     * @param key 键
     * @return 剩余时间(秒)
     */
    public long getExpire(String key) {
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire != null ? expire : -1;
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return 是否存在
     */
    public boolean hasKey(String key) {
        try {
            return Boolean.TRUE.equals(redisTemplate.hasKey(key));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 删除key
     * @param keys 可以传一个或多个key
     */
    public void delete(String... keys) {
        if (keys != null && keys.length > 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
                redisTemplate.delete(Arrays.asList(keys));
            }
        }
    }

    // ---------------------- String Operations ----------------------

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存(String类型)
     * @param key 键
     * @return 字符串值
     */
    public String getAsString(String key) {
        Object value = get(key);
        return value != null ? value.toString() : null;
    }

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置缓存并设置过期时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     */
    public void set(String key, Object value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            set(key, value);
        }
    }

    /**
     * 批量设置
     * @param map 键值对
     */
    public void multiSet(Map<String, Object> map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 递增
     * @param key 键
     * @param delta 增量
     * @return 递增后的值
     */
    public long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key 键
     * @param delta 减量
     * @return 递减后的值
     */
    public long decrement(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    // ---------------------- Hash Operations ----------------------

    /**
     * 获取Hash中的所有字段和值
     * @param key 键
     * @return 字段和值的Map
     */
    public Map<Object, Object> hashGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取Hash中指定字段的值
     * @param key 键
     * @param field 字段
     * @return 值
     */
    public Object hashGet(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 设置Hash中多个字段的值
     * @param key 键
     * @param map 字段和值的Map
     */
    public void hashPutAll(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 设置Hash中一个字段的值
     * @param key 键
     * @param field 字段
     * @param value 值
     */
    public void hashPut(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 删除Hash中的字段
     * @param key 键
     * @param fields 可以传一个或多个字段
     */
    public void hashDelete(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 判断Hash中是否存在某字段
     * @param key 键
     * @param field 字段
     * @return 是否存在
     */
    public boolean hashHasKey(String key, String field) {
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * Hash递增
     * @param key 键
     * @param field 字段
     * @param delta 增量
     * @return 递增后的值
     */
    public long hashIncrement(String key, String field, long delta) {
        return redisTemplate.opsForHash().increment(key, field, delta);
    }

    /**
     * Hash递减
     * @param key 键
     * @param field 字段
     * @param delta 减量
     * @return 递减后的值
     */
    public long hashDecrement(String key, String field, long delta) {
        return redisTemplate.opsForHash().increment(key, field, -delta);
    }

    // ---------------------- Set Operations ----------------------

    /**
     * 获取Set中的所有成员
     * @param key 键
     * @return 成员集合
     */
    public Set<Object> setMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 判断Set中是否存在某值
     * @param key 键
     * @param value 值
     * @return 是否存在
     */
    public boolean setIsMember(String key, Object value) {
        return Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(key, value));
    }

    /**
     * 向Set中添加元素
     * @param key 键
     * @param values 可以传一个或多个值
     * @return 成功添加的数量
     */
    public long setAdd(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 获取Set的大小
     * @param key 键
     * @return 大小
     */
    public long setSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 移除Set中的值
     * @param key 键
     * @param values 可以传一个或多个值
     * @return 移除的数量
     */
    public long setRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    // ---------------------- List Operations ----------------------

    /**
     * 获取List中的元素
     * @param key 键
     * @param start 开始索引
     * @param end 结束索引
     * @return 元素列表
     */
    public List<Object> listRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获取List的大小
     * @param key 键
     * @return 大小
     */
    public long listSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 通过索引获取List中的元素
     * @param key 键
     * @param index 索引
     * @return 元素
     */
    public Object listIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 向List头部添加元素
     * @param key 键
     * @param value 值
     * @return 操作后的列表大小
     */
    public long listLeftPush(String key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 向List头部批量添加元素
     * @param key 键
     * @param values 值数组
     * @return 操作后的列表大小
     */
    public long listLeftPushAll(String key, Object... values) {
        return redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * 向List尾部添加元素
     * @param key 键
     * @param value 值
     * @return 操作后的列表大小
     */
    public long listRightPush(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 向List尾部批量添加元素
     * @param key 键
     * @param values 值数组
     * @return 操作后的列表大小
     */
    public long listRightPushAll(String key, Object... values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * 从List头部移除并返回元素
     * @param key 键
     * @return 移除的元素
     */
    public Object listLeftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 从List尾部移除并返回元素
     * @param key 键
     * @return 移除的元素
     */
    public Object listRightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    // ---------------------- Pipeline Operations ----------------------

    /**
     * 执行管道操作
     * @param callback 管道回调
     * @return 执行结果
     */
    public List<Object> executePipeline(RedisCallback<?> callback) {
        return redisTemplate.executePipelined(callback);
    }

    // ---------------------- Transaction Operations ----------------------

    /**
     * 执行事务操作
     * @param callback 事务回调
     * @return 执行结果
     */
    public Object executeTransaction(SessionCallback<?> callback) {
        return redisTemplate.execute(callback);
    }
}