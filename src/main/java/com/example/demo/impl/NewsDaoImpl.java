package com.example.demo.impl;

import com.example.demo.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String createNewsTable() {
        String sql = "CREATE TABLE `news` (" +
                "  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '新聞編號'," +
                "  `news_content` blob NOT NULL COMMENT '新聞內容'," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

        jdbcTemplate.execute(sql);
        return "success create the table";

    }
}
