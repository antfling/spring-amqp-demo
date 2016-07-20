package com.spring.amqp.demo.handler;

import com.spring.amqp.demo.domain.QueueTest;
import com.spring.amqp.demo.exception.FanoutTestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author love
 * @since 2016/7/19.
 */
@Component
@Slf4j
public class FanoutExchangeHandler {

    @RabbitListener(queues = "#{fanoutExchangeQueue_1}")
    public void fanoutQueue1(QueueTest queueTest) {
        log.error("fanoutQueue1111---->" + queueTest);
        if (queueTest.getMessageId()==2){
            throw new FanoutTestException();
        }
    }

    @RabbitListener(queues = "#{fanoutExchangeQueue_2}")
    public void fanoutQueue2(QueueTest queueTest) {
        log.error("fanoutQueue2222---->" + queueTest);
    }
}
