package com.jwt.ocrrabbitmqesdemo.facade.mq.servie;

public interface MessageQueueSendService {

    /**
     * 发送消息到 ** 队列
     *
     * @param msg 发送的对象
     */
    void sendArchiveMessage(Object msg);
}
