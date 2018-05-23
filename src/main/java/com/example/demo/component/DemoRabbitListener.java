package com.example.demo.component;

import com.example.demo.domain.Partition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoRabbitListener {

    private static final Logger logger = LoggerFactory.getLogger(DemoRabbitListener.class);

    @RabbitListener(queues = "demo")
    public void processMessage(Partition partition) {
        logger.info("received: {}", partition);
    }

}
