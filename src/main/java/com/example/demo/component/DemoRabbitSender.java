package com.example.demo.component;

import com.example.demo.domain.Partition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DemoRabbitSender {

    private static final Logger logger = LoggerFactory.getLogger(DemoRabbitSender.class);

    private static final String queueName = "demo";

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public DemoRabbitSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send() {
        Partition p = new Partition();
        p.setName("demo");
        p.setStart(11111L);
        p.setEnd(99999L);

        this.amqpTemplate.convertAndSend(queueName, p);
    }

    @Async
    public void asyncSend() {
        logger.info("asyncSendToRabbit()");
        send();
    }
}
