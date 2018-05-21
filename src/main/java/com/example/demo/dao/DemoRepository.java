package com.example.demo.dao;

import com.example.demo.domain.Partition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DemoRepository {

    private static final Logger logger = LoggerFactory.getLogger(DemoRepository.class);

    private final JdbcTemplate jdbcTemplate;

    private RowMapper<Partition> rowMapper = new BeanPropertyRowMapper<>(Partition.class);

    @Autowired
    public DemoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void demo() {
        List<Map<String, Object>> list =
                this.jdbcTemplate.queryForList("select PARTITION_NAME, START, END from `partition`;");
        logger.info("partitions: {}", list);
    }

    public void demo2() {
        List<Partition> list =
                this.jdbcTemplate.query("select PARTITION_NAME as name, START, END from `partition`;", rowMapper);
        logger.info("partitions: {}", list);
    }
}
