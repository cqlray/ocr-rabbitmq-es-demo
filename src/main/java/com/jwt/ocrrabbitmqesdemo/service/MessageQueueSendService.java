package com.jwt.ocrrabbitmqesdemo.service;

public interface MessageQueueSendService {

    /**
     * 发送消息到 ** 队列
     *
     * @param msg 发送的对象
     */
    void sendArchiveMessage(Object msg);
}
