package com.yanshen.Kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Project: Springboot-mybatis
 * Package: com.yanshen.Kafka
 * Author: cuiyanchao
 * CreateTime: 2019-08-15 14:05:27
 * Description: ${Description}
 */
@Component
public class KafakaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafakaConsumer.class);

    @KafkaListener(topics = {"LOGIN_USERINFO"})
    public void listenLoginInfo(ConsumerRecord<String, String> recordList) {
        logger.info(String.valueOf(recordList));
        ConsumerRecord<String, String> lsit =recordList;


    }
}
