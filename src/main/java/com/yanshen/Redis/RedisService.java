package com.yanshen.Redis;

import com.yanshen.entity.User;
import com.yanshen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Project: Springboot-mybatis
 * Package: com.yanshen.Redis
 * Author: cuiyanchao
 * CreateTime: 2019-08-15 11:16:55
 * Descri
 *
 * @Sption: ${Description}
 */
@Service
public class RedisService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private UserService userService;

    public Map<String, Object> getUserInfo(User user) {

        Map<String, Object> map = redisClient.mapGetAll(user.getUserName(), String.class, Object.class);
        if (map == null || map.size() == 0) {
            try {
                Map<String, Object> map1 = userService.getUser(user);
                redisClient.mapPutAll(user.getUserName(), map1);
                LOGGER.info("放入Redis成功");
                return map1;
            } catch (Exception e) {
                return null;
            }
        } else {
            LOGGER.info("直接取Redis数据" + map.toString());
            return map;
        }
    }
}
