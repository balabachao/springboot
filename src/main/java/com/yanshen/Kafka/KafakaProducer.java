package com.yanshen.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

/**
 * Project: Springboot-mybatis
 * Package: com.yanshen.Kafka
 * Author: cuiyanchao
 * CreateTime: 2019-08-15 13:42:48
 * Description: ${Description}
 */
@Component
public class KafakaProducer {
    private final Logger logger = LoggerFactory.getLogger(KafakaProducer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendKafka(String topic, String msg) {
        this.sendKafka(topic, null, msg, (Throwable throwable) -> defaultOnFail(throwable, topic, msg), (SendResult sendResult) -> defaultOnSuccess(topic, msg));

    }

    public void defaultOnFail(Throwable throwable, String topic, String msg) {
        logger.info("send kafka fail,topic:{},message:{}", topic, msg);
        logger.error("fail exception", throwable);
    }

    public void defaultOnSuccess(String topic, String msg) {
        logger.info("send kafka success,topic:{},message:{}", topic, msg);
    }

    public void sendKafka(String topic, String key, String msg, FailureCallback failureCallback, SuccessCallback<? super SendResult> successCallback) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, msg);
        future.addCallback(successCallback, failureCallback);
    }
}
