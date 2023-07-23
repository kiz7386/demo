package com.example.demo.impl;

import com.example.demo.dao.ClassOrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ClassOrderDaoImpl implements ClassOrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String createClassOrderTable() {
        String sql = "CREATE TABLE `class_order` (" +
                " `id` bigint NOT NULL AUTO_INCREMENT COMMENT '課程訂單編號'," +
                "  `user_id` bigint NOT NULL COMMENT '會員編號'," +
                "  `class_id` bigint NOT NULL COMMENT '課程編號'," +
                "  PRIMARY KEY (`id`)," +
                "  KEY `user_id` (`user_id`)," +
                "  KEY `class_id` (`class_id`)," +
                "  CONSTRAINT `class_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)," +
                "  CONSTRAINT `class_order_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

        jdbcTemplate.execute(sql);
        return "success create the table";

    }

    @Override
    public String saveClassOrder(Integer userId, Integer classId){
        String sql = "INSERT INTO class_order (user_id, class_id) VALUES (?, ?)";
        int update = jdbcTemplate.update(sql, userId, classId);
        if(update > 0){
            log.info(String.format("新增會員課程訂單 userId:'%s' classId:'%s', 成功", userId, classId ));
        }
        return "success";
    }

}
