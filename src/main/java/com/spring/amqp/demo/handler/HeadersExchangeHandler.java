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
public class HeadersExchangeHandler {

    @RabbitListener(queues = "#{headersExchangeQueue_1}")
    public void headersQueueTest1(QueueTest queueTest) {
        log.error("headersQueueTest1----------->" + queueTest);
    }

    @RabbitListener(queues = "#{headersExchangeQueue_2}")
    public void headersQueueTest2(QueueTest queueTest) {
        log.error("headersQueueTest2----------->" + queueTest);
    }

    @RabbitListener(queues = "#{headersExchangeQueue_3}")
    public void headersQueueTest3(QueueTest queueTest) {
        log.error("headersQueueTest3----------->" + queueTest);
    }
}
