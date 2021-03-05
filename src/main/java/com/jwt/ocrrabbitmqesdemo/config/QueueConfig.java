package com.jwt.ocrrabbitmqesdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    /**
     * 定义传输类型为延时队列
     */
    public static final String X_DELAYED_MESSAGE = "x-delayed-message";

    public static final String X_DELAYED_TYPE = "x-delayed-type";

    /**
     * 定义交换机的类型
     */
    public static final String EXCHANGE_TYPE = "direct";


    /**
     * 定义队列名称
     */
    public static final String ARCHIVE_QUEUE = "archive_queue";

    /**
     * 定义交换机的名称
     */
    public static final String ARCHIVE_EXCHANGE = "archive_exchange";
    /**
     * 定义routingKey
     */
    public static final String ARCHIVE_ROUTING_KEY = "archive.new";

    @Bean
    public Queue archiveQueue() {
        return new Queue(ARCHIVE_QUEUE, true);
    }

    @Bean
    public FanoutExchange archiveExchange() {
        return new FanoutExchange(ARCHIVE_EXCHANGE, true, false);
    }
    @Bean
    public Binding archiveBinding() {
        return BindingBuilder.bind(archiveQueue()).to(archiveExchange());
    }

}
