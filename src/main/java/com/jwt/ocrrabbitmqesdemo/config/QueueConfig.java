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
     * **********************
     * 即时消息
     * **********************
     */

    /**
     * 定义队列名称
     */
    public static final String ARCHIVE_QUEUE = "archive_queue";

    /**
     * 定义交换机的名称
     */
    public static final String ARCHIVE_EXCHANGE = "archive_exchange";


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


    /**
     * **********************
     * 延迟消息
     * **********************
     */

    /**
     * 定义传输类型为延时队列
     */
    public static final String X_DELAYED_MESSAGE = "x-delayed-message";

    public static final String X_DELAYED_TYPE = "x-delayed-type";

    /**
     * 定义交换机的名称
     */
    public static final String TASK_EXCHANGE = "task_exchange";
    /**
     * 定义交换机的类型
     */
    public static final String EXCHANGE_TYPE = "direct";

    /**
     * 定义队列名称 - 标的队列
     */
    public static final String SUBJECT_QUEUE = "subject_queue";

    /**
     * 定义标的的routingKey
     */
    public static final String SUBJECT_ROUTING_KEY = "subject.task";

//    @Bean
//    public CustomExchange delayExchange() {
//        Map<String, Object> args = new HashMap<>();
//        args.put(X_DELAYED_TYPE, EXCHANGE_TYPE);
//        return new CustomExchange(TASK_EXCHANGE, X_DELAYED_MESSAGE, true, false, args);
//    }

    @Bean
    public FanoutExchange delayExchange() {

        return new FanoutExchange(TASK_EXCHANGE, true, false);
    }

    @Bean
    public Queue subjectQueue() {
        return new Queue(SUBJECT_QUEUE, true);
    }

//    @Bean
//    public Binding subjectBinding() {
//        return BindingBuilder.bind(subjectQueue()).to(delayExchange())
//                .with(SUBJECT_ROUTING_KEY).noargs();
//    }
    @Bean
    public Binding subjectBinding() {
        return BindingBuilder.bind(subjectQueue()).to(delayExchange());
    }

}
