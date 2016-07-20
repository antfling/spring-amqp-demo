package com.spring.amqp.demo.handler;

import com.spring.amqp.demo.domain.QueueTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author love
 * @since 2016/7/20.
 */
@Component
@Slf4j
public class DirectExchangeHandler {

    @RabbitListener(queues = "#{directExchangeQueue_1}")
    public void directQueueTest1(QueueTest queueTest){
        log.error("directQueueTest1----------->"+queueTest);
    }

    @RabbitListener(queues = "#{directExchangeQueue_2}")
    public void directQueueTest2(QueueTest queueTest){
        log.error("directQueueTest2----------->"+queueTest);
    }

    @RabbitListener(queues = "#{directExchangeQueue_3}")
    public void directQueueTest3(QueueTest queueTest){
        log.error("directQueueTest3----------->"+queueTest);
    }
}
