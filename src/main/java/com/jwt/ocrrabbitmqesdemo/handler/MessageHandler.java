package com.jwt.ocrrabbitmqesdemo.handler;

import cn.hutool.core.date.DateUtil;
import com.jwt.ocrrabbitmqesdemo.config.QueueConfig;
import com.jwt.ocrrabbitmqesdemo.dto.ArchiveDto;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RabbitListener(queues = {QueueConfig.ARCHIVE_QUEUE})
public class MessageHandler {
    private AtomicInteger atomicInteger = new AtomicInteger();

    @RabbitHandler
    public void getMessageFromArchive(@Payload ArchiveDto archiveDto, @Header(AmqpHeaders.DELIVERY_TAG)long deliveryTag, Channel channel) throws IOException {
        log.info("{} need to change status at {}", archiveDto, DateUtil.now());
        channel.basicAck(deliveryTag, false);
    }

    @RabbitHandler
    public void getMessageFromArchive(@Payload String message,@Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
//        Integer count = atomicInteger.incrementAndGet();
//        log.info("{} need to change status at {}, count:{}", message, DateUtil.now(), count);
//        if (count % 2 != 0) {
//            //测试消息处理失败后重新入队列
//            channel.basicNack(deliveryTag, false, true);
//        } else {
//            atomicInteger.set(0);
//            //消息成功处理后发送确认
//            channel.basicAck(deliveryTag, false);
//        }
        log.info("{} need to change status at {}, count:{}", message, DateUtil.now());
        channel.basicAck(deliveryTag, false);
    }
}
