package com.example.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class DemoMongoRepository {

    private static final Logger logger = LoggerFactory.getLogger(DemoMongoRepository.class);

    private static final String COLLECTION = "demo";

    private final MongoTemplate mongoTemplate;

    @Autowired
    public DemoMongoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void demo() {
        List<HashMap> data = this.mongoTemplate.find(new Query(), HashMap.class, COLLECTION);
        logger.info("mongo data: {}", data);
    }
}
