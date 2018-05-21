package com.example.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DemoRepository {

    private static final Logger logger = LoggerFactory.getLogger(DemoRepository.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DemoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void demo() {
        List<Map<String, Object>> list =
                this.jdbcTemplate.queryForList("select PARTITION_NAME, START, END from `partition`;");
        logger.info("partitions: {}", list);
    }
}
