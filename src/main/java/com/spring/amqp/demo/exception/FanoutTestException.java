package com.spring.amqp.demo.exception;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;

/**
 * @author love
 * @since 2016/7/19.
 */
public class FanoutTestException extends AmqpRejectAndDontRequeueException {

    public FanoutTestException() {
        super("fanout test exception");
    }
}
