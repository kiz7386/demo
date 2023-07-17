package com.example.demo.mapper;

import com.example.demo.model.vo.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper {
    @Select("SELECT * FROM class WHERE id in " +
            " (SELECT class_id FROM class_order WHERE user_id = #{id})")
    public Class getUserClassData(@Param("id") Integer id);

}
