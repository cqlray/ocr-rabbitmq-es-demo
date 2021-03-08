package com.jwt.ocrrabbitmqesdemo.service;

public interface MessageQueueSendService {

    /**
     * 发送消息到 ** 队列
     *
     * @param msg 发送的对象
     */
    void sendArchiveMessage(Object msg);

    /**
     * 发送延迟消息到消息队列
     *
     * @param msg        发送的消息
     * @param timeout    过期时间
     */
    void sendDelayMessage(Object msg, Long timeout);
}
