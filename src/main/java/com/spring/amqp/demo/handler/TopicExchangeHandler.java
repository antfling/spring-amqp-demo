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
public class TopicExchangeHandler {

    @RabbitListener(queues = "#{topicExchangeQueue_1}")
    public void TopicQueueTest1(QueueTest queueTest) {
        log.error("TopicQueueTest1----------->" + queueTest);
    }

    @RabbitListener(queues = "#{topicExchangeQueue_2}")
    public void TopicQueueTest2(QueueTest queueTest) {
        log.error("TopicQueueTest2----------->" + queueTest);
    }

    @RabbitListener(queues = "#{topicExchangeQueue_3}")
    public void TopicQueueTest3(QueueTest queueTest) {
        log.error("TopicQueueTest3----------->" + queueTest);
    }
}
