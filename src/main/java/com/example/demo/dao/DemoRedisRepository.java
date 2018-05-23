package com.example.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoRedisRepository {

    private static final Logger logger = LoggerFactory.getLogger(DemoRedisRepository.class);

    private StringRedisTemplate template;

    @Autowired
    public DemoRedisRepository(StringRedisTemplate template) {
        this.template = template;
    }

    public void demo() {
        Long size = this.template.opsForList().size("demoList");
        logger.info("demoList size: {}", size);

        String value = this.template.opsForList().index("demoList", 0);
        logger.info("demoList[0]: {}", value);
    }
}
