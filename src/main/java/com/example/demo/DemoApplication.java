package com.example.demo;

import com.example.demo.component.DemoRabbitSender;
import com.example.demo.dao.DemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private final DemoRepository demoRepository;

    private final DemoRabbitSender demoRabbitSender;

    @Autowired
    public DemoApplication(DemoRepository demoRepository, DemoRabbitSender demoRabbitSender) {
        this.demoRepository = demoRepository;
        this.demoRabbitSender = demoRabbitSender;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Hello World!");
        this.demoRepository.demo();
        this.demoRepository.demo2();

        demoRabbitSender.send();
    }
}
