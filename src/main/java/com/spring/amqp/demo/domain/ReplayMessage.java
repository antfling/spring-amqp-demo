package com.spring.amqp.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author love
 * @since 2016/7/20.
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class ReplayMessage implements Serializable {
    private String replayMessage;

    private Integer replayCode;
}
