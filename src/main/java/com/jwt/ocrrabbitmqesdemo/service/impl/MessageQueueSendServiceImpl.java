package com.jwt.ocrrabbitmqesdemo.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.ContentType;
import com.jwt.ocrrabbitmqesdemo.config.QueueConfig;
import com.jwt.ocrrabbitmqesdemo.service.MessageQueueSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageQueueSendServiceImpl implements MessageQueueSendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void sendArchiveMessage(Object msg) {
        log.info("{} is need to send msg is{}", DateUtil.now(), msg);
        rabbitTemplate.convertAndSend(QueueConfig.ARCHIVE_EXCHANGE, "", msg, message -> {
            message.getMessageProperties().setHeader("content_type", ContentType.JSON);
            return message;
        });
        log.info("archive message send successful");
    }
}
