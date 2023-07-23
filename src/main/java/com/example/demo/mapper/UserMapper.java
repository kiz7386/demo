package com.example.demo.mapper;

import com.example.demo.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper{
    @Select("SELECT * FROM user WHERE id = #{id}")
    public UserVO getUserData(@Param("id") Integer id);
    @Select({"<script>" +
            "SELECT * FROM user WHERE 1=1 " +
            "  <if test = 'idList != null and idList.size() != 0'>" +
            "  AND id in "+
            "   <foreach collection=\"idList\" item=\"id\" open=\"(\" close=\")\" separator=\",\">" +
            "      #{id}" +
            "   </foreach>"+
            "  </if>"+
            "</script>"})
    public List<UserVO> getUserList(@Param("idList") List<Integer> idList);
}
