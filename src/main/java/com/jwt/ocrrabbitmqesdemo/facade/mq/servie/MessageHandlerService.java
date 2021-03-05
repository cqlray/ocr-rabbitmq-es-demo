package com.jwt.ocrrabbitmqesdemo.facade.mq.servie;

import com.jwt.ocrrabbitmqesdemo.facade.es.dto.ArchiveDto;
import com.jwt.ocrrabbitmqesdemo.facade.mq.dto.ArchiveDataDto;
import com.rabbitmq.client.Channel;

public interface MessageHandlerService {
    /**
     * 从指定的消息队列 - archive_queue中获取对应的数据信息
     * @param archiveDto {@link ArchiveDataDto }
     */
    void getMessageFromArchive(ArchiveDto archiveDto, long deliveryTag, Channel channel);
    void getMessageFromArchive(String message, long deliveryTag, Channel channel);
}
