package com.example.demo.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String createUserTable() {
        String sql = "CREATE TABLE `user` (" +
                "  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '會員編號'," +
                "  `user_name` varchar(30) NOT NULL COMMENT '會員名稱'," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

        jdbcTemplate.execute(sql);
        return "success create the table";

    }


    @Override
    public String saveUser(String className){
        String sql = "INSERT INTO class (class_name) VALUES (?)";
        int update = jdbcTemplate.update(sql, className);
        if(update > 0){
            log.info(String.format("新增課程名稱 '%s', 成功", className ));
        }
        return "success";
    }

    @Override
    public UserVO queryUser(Integer id) {
        String sql = " SELECT *  FROM user WHERE id = ? ";
        List<UserVO> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserVO>(UserVO.class), new Object[] { id });
        if(result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<UserVO> getUserDataList(List<Integer> ids) {
        String sql = " SELECT * FROM user WHERE id in ( %s )";
        String inParams = String.join(",", ids.stream().map(id -> "?").collect(Collectors.toList()));
        List<UserVO> result = jdbcTemplate.query(
                String.format(sql, inParams), ids.toArray(), new BeanPropertyRowMapper<UserVO>(UserVO.class));
        if(result != null && result.size() > 0) {
            return result;
        }
        return null;
    }
}
