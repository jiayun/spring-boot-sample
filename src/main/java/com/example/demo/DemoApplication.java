package com.example.demo;

import com.example.demo.component.DemoRabbitSender;
import com.example.demo.dao.DemoMongoRepository;
import com.example.demo.dao.DemoRedisRepository;
import com.example.demo.dao.DemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private final DemoRepository demoRepository;

    private final DemoRabbitSender demoRabbitSender;

    private final DemoRedisRepository demoRedisRepository;

    private final DemoMongoRepository demoMongoRepository;

    @Autowired
    public DemoApplication(DemoRepository demoRepository, DemoRabbitSender demoRabbitSender, DemoRedisRepository demoRedisRepository, DemoMongoRepository demoMongoRepository) {
        this.demoRepository = demoRepository;
        this.demoRabbitSender = demoRabbitSender;
        this.demoRedisRepository = demoRedisRepository;
        this.demoMongoRepository = demoMongoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Hello World!");
        this.demoRepository.demo();
        this.demoRepository.demo2();

        this.demoRabbitSender.asyncSend();
        this.demoRabbitSender.asyncSend();
        this.demoRabbitSender.asyncSend();

        this.demoRedisRepository.demo();
        this.demoMongoRepository.demo();
    }

    @Scheduled(fixedRate = 1000)
    public void sendToRabbit() {
        this.demoRabbitSender.send();
    }
}
