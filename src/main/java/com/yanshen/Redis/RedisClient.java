package com.yanshen.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Project: Springboot-mybatis
 * Package: com.yanshen.Redis
 * Author: cuiyanchao
 * CreateTime: 2019-08-15 11:14:24
 * Description: ${Description}
 */
@Component
public class RedisClient {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean put(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public Object get(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public List<Object> getValue(String key) {
        try {
            return redisTemplate.opsForList().range(key, 0L, 19L);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception var2) {
            var2.printStackTrace();
            return false;
        }
    }

    public <T> T get(String key, Class<T> requiredType) {
        try {
            Object o = redisTemplate.opsForValue().get(key);
            if (requiredType.isInstance(o)) {
                return requiredType.cast(o);
            } else {
                throw new RuntimeException(o + " is not a " + requiredType.getName());
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public boolean leftPush(String key, Object value) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public boolean leftPushAll(String key, List<?> value) {
        try {
            redisTemplate.opsForList().leftPushAll(key, new Object[]{value});
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public <T> T leftPop(String key, Class<T> requiredType) {
        try {
            Object o = redisTemplate.opsForList().leftPop(key);
            if (requiredType.isInstance(o)) {
                return requiredType.cast(o);
            } else {
                throw new RuntimeException(o + " is not a " + requiredType.getName());
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public <T> List<T> leftRange(String key, Class<T> requiredType) {
        try {
            Long size = redisTemplate.opsForList().size(key);
            List<Object> lsto = redisTemplate.opsForList().range(key, 0L, size);
            List<T> lst = new ArrayList();
            lsto.forEach((o) -> {
                if (requiredType.isInstance(o)) {
                    lst.add(requiredType.cast(o));
                }

            });
            return lst;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public boolean mapPut(String key, Object hashKey, Object value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean mapPutexpire(String key, Object hashKey, Object value, long days) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            redisTemplate.expire(key, days, TimeUnit.DAYS);
            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }

    public boolean mapPutAll(String key, Map<?, ?> m) {
        try {
            redisTemplate.opsForHash().putAll(key, m);
            redisTemplate.expire(key, 1800L, TimeUnit.SECONDS);
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public <HV> HV mapGet(String key, Object hashKey, Class<HV> requiredType) {
        try {
            Object o = redisTemplate.opsForHash().get(key, hashKey);
            if (requiredType.isInstance(o)) {
                return requiredType.cast(o);
            } else {
                throw new RuntimeException(o + " is not a " + requiredType.getName());
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public <HK, HV> Map<HK, HV> mapGetAll(String key, Class<HK> HK, Class<HV> HV) {
        try {
            Map<?, ?> map = redisTemplate.opsForHash().entries(key);
            Map<HK, HV> m = new HashMap();
            map.forEach((k, v) -> {
                if (HK.isInstance(k) && HV.isInstance(v)) {
                    m.put(HK.cast(k), HV.cast(v));
                }

            });
            return m;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public boolean setKeyTimeOut(String key, Object value, int time) {
        redisTemplate.opsForValue().set(key, value);
        boolean expire = redisTemplate.expire(key, (long) time, TimeUnit.SECONDS);
        return expire;
    }

    public void redisPublishForRedisTemplate2(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }

    public <HV> HV mapGetForRedisTemplate2(String key, Object hashKey, Class<HV> requiredType) {
        try {
            Object o = redisTemplate.opsForHash().get(key, hashKey);
            if (requiredType.isInstance(o)) {
                return requiredType.cast(o);
            } else {
                throw new RuntimeException(o + " is not a " + requiredType.getName());
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public boolean mapPutAll(String key, Map<?, ?> m, Integer time) {
        try {
            redisTemplate.opsForHash().putAll(key, m);
            redisTemplate.expire(key, (long) time, TimeUnit.SECONDS);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean delete(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception var2) {
            var2.printStackTrace();
            return false;
        }
    }

    public boolean copy(String key, String destKey) {
        try {
            Set set = new HashSet();
            redisTemplate.opsForSet().differenceAndStore(key, set, destKey);
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public boolean setPut(String key, Object hashKey) {
        try {
            redisTemplate.opsForSet().add(key, new Object[]{hashKey});
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public boolean isSetMember(String key, Object hashKey) {
        try {
            return redisTemplate.opsForSet().isMember(key, hashKey);
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public Set<Object> isSetMember(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public Set<Object> sdiff(String key, String otherKey) {
        try {
            return redisTemplate.opsForSet().difference(key, otherKey);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

}
