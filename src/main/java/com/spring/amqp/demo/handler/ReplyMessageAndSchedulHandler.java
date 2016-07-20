package com.spring.amqp.demo.handler;

import com.spring.amqp.demo.domain.QueueTest;
import com.spring.amqp.demo.domain.ReplayMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author love
 * @since 2016/7/20.
 */
@Component
@Slf4j
public class ReplyMessageAndSchedulHandler {
    @Autowired
    private volatile RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "0 0/1 9-23 * * ?")
    public void scheduled() {
        QueueTest queueTest = new QueueTest("sendMessage", new Random(100).nextInt());
        ReplayMessage replayMessage = (ReplayMessage) rabbitTemplate
                .convertSendAndReceive("spring.air.send.message.queue", queueTest);
        log.error(LocalDateTime.now() + ":i got your reply message:" + replayMessage);
    }

    @RabbitListener(queues = "spring.air.send.message.queue")
    public ReplayMessage receive(QueueTest queueTest) {
        log.error(LocalDateTime.now() + ":i have receive this message:" + queueTest);
        return new ReplayMessage("replay to you message :", new Random(100).nextInt());
    }
}
