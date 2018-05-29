package com.example.demo.dao;

import com.example.demo.domain.Partition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class Demo2Repository {

    private static final Logger logger = LoggerFactory.getLogger(Demo2Repository.class);

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<Partition> rowMapper = new BeanPropertyRowMapper<>(Partition.class);

    @Autowired
    public void setDataSource(@Qualifier("demo2DataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void demo() {
        List<Partition> list =
                this.jdbcTemplate.query("select PARTITION_NAME as name, START, END from `partition`;", rowMapper);
        logger.info("partitions: {}", list);
    }
}
