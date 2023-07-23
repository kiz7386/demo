package com.example.demo.impl;

import com.example.demo.dao.ClassDao;
import com.example.demo.model.vo.ClassVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ClassDaoImpl implements ClassDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String createClassTable() {
        String sql = "CREATE TABLE `class` (" +
                "  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '課程編號'," +
                "  `class_name` varchar(50) NOT NULL COMMENT '課程名稱'," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

        jdbcTemplate.execute(sql);
        return "success create the table";

    }

    @Override
    public ClassVO queryClass(Integer id) {
        String sql = "SELECT * FROM class WHERE id in " +
                        " (SELECT class_id FROM class_order WHERE user_id = ?)";

        List<ClassVO> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ClassVO>(ClassVO.class), new Object[] { id });
        if(result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }


    @Override
    public List<ClassVO> getClassDataList(List<Integer> ids) {
        String sql = " SELECT * FROM class WHERE id in ( %s )";
        String inParams = String.join(",", ids.stream().map(id -> "?").collect(Collectors.toList()));
        List<ClassVO> result = jdbcTemplate.query(
                String.format(sql, inParams), ids.toArray(), new BeanPropertyRowMapper<ClassVO>(ClassVO.class));
        if(result != null && result.size() > 0) {
            return result;
        }
        return new ArrayList<>();
    }

    @Override
    public String saveClass(String className){
        String sql = "INSERT INTO class (class_name) VALUES (?)";
        int update = jdbcTemplate.update(sql, className);
        if(update > 0){
            log.info(String.format("新增課程名稱 '%s', 成功", className ));
        }
        return "success";
    }

    @Override
    public String updateClassName(String className, Integer id) {
        String sql = "UPDATE class SET class_name = ? WHERE ID = ?";
        int update = jdbcTemplate.update(sql, className, id);
        if(update > 0){
            log.info(String.format("修改課程名稱 id = %s, 成功", id ));
        }
        return "success";
    }

    @Override
    public String deleteClass(Integer id) {
        String sql = " DELETE FROM class WHERE id = ?";
        int update = jdbcTemplate.update(sql, id);
        if(update > 0){
            log.info(String.format("刪除id = %s, 成功", id ));
        }
        return "success";
    }


}
