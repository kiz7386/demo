package com.example.demo.dao;

import com.example.demo.model.vo.UserVO;

import java.util.List;

public interface UserDao {
    public String createUserTable();
    public String saveUser(String userName);
    public UserVO queryUser(Integer id);
    public List<UserVO> getUserDataList(List<Integer> id);
}
