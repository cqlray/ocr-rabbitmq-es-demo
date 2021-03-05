package com.jwt.ocrrabbitmqesdemo.service.mq.impl;

import cn.hutool.core.date.DateUtil;
import com.jwt.ocrrabbitmqesdemo.config.QueueConfig;
import com.jwt.ocrrabbitmqesdemo.facade.es.dto.ArchiveDto;
import com.jwt.ocrrabbitmqesdemo.facade.mq.servie.MessageHandlerService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RabbitListener(queues = {QueueConfig.ARCHIVE_QUEUE})
public class MessageHandlerServiceImpl implements MessageHandlerService {

    @Override
    @RabbitHandler
    public void getMessageFromArchive(@Payload ArchiveDto archiveDto, @Header(AmqpHeaders.DELIVERY_TAG)long deliveryTag, Channel channel) {
        try {
            log.info("{} need to change status at {}", archiveDto, DateUtil.now());
            channel.basicAck(deliveryTag, false);
        }catch (IOException e){
        }
    }

    @Override
    @RabbitHandler
    public void getMessageFromArchive(@Payload String message,@Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
        try {
            log.info("{} need to change status at {}", message, DateUtil.now());
            channel.basicAck(deliveryTag, false);
        }catch (IOException e){
        }
    }
}
